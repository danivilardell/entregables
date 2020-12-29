function XF = xy_trF(x, n, F)
    XF = 0;
    for k = 1:length(n)
        XF = XF + x(k)*exp(-1i*2*pi*F*n(k));
    end
    return;
end
