b = fred.copy()
A_ini = Ared.copy()
ured = eliminacioGaussiana_banda(Ared, fred, 5*nRefinament)

b2 = A_ini@ured
sonIguals = max(abs(b - b2))<1e-9
print("Sistema resolt:", sonIguals) 
print("Temps: ", time.time() - t0)
#Output:
#   Sistema resolt: True
#   Temps:  0.0015139579772949219