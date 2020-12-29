#model problema braquistocrona

param n >= 0;
param a >= 0;
param b >= 0;
param eps > 0;

var XS{i in 0..n} >= 0 default i*a/n;
var YS{i in 0..n} >= 0 default i*b/n;

#Funcio objectiu
minimize c: 
sum{i in 1..n} sqrt(((YS[i] - YS[i - 1])**2 + (XS[i] - XS[i - 1])**2)/(YS[i] + eps) + eps);

#Restriccions
subject to iniciy: YS[0] = 0;
subject to inicix: XS[0] = 0;
subject to finaly: YS[n] = b;
subject to finalx: XS[n] = a;