f = @(x) abs(1/5*((sin(pi*10*(x - 0.25))/sin(pi*(x - 0.25))) + (sin(pi*10*(x + 0.25))/sin(pi*(x + 0.25)))));
vec = mostr(18, f);
stem(vec);
Ma = trova(vec);
disp(Ma);

%Mostreja la senyal
function XF = mostr(N, F) 
    XF = 0;
    for k = 1:N
        XF(k) = F(k/N);
    end
    return;
end

%Troba els maxims d'un vector
function maxims = trova(vec)
    maxims = 0;
    contador = 1;
    if(vec(1) > vec(2)) 
        maxims(contador, 1) = 1;
        maxims(contador, 2) = vec(1);
        contador = contador + 1;
    end
    for k = 2:length(vec) - 1
        if(vec(k - 1) < vec(k) && vec(k + 1) < vec(k)) 
            maxims(contador, 1) = k;
            maxims(contador, 2) = vec(k);
            contador = contador + 1;
        end
    end
    if(vec(length(vec)) > vec(length(vec) - 1)) 
        maxims(contador, 1) = length(vec);
        maxims(contador, 2) = vec(length(vec));
        contador = contador + 1;
    end
    return;
end
