def eliminacioGaussiana_banda(A, b,s):
    n=len(A)
    if b.size != n:
        raise ValueError("Error: les dimensions de A i b no coincideixen", b.size, n)
    for k in range(n-1):
        for i in range(k+1, min(n,k+s)):
            alpha = A[i,k]/A[k,k]
            A[i,k]=0
            A[i, k+1:min(n, k + s)] -= alpha*A[k,k + 1:min(n, k + s)]
#           for j in range(k+1, min(n,k+s)):
#               A[i,j] = A[i,j] - alpha*A[k,j]
            b[i] = b[i] - alpha*b[k]
    x = substitucioEnrera_banda(A,b,s)
    return x

def substitucioEnrera_banda(A, b, s): 
    n = len(A)
    x = np.zeros(n)
    for i in range(n - 1, -1, -1):
        banda = b[i]
        banda -= np.dot(A[i,i+1:min(n,i+s)], x[i+1:min(n,i+s)])
#       for j in range(i + 1, min(n, i + s)):
#           banda -= x[j]*A[i,j]
        x[i] = banda/A[i,i]
    return x