package projecteuler45;

public class ProjectEuler45 {

    public static void main(String[] args) {
        long i = 1;
        while(true){
            long triangular = getTriangular(i++);
            if(isPentagonal(triangular) && isHexagonal(triangular)) System.out.println(triangular + " = T" + getTriangularOrdinal(triangular) + " = H" + getHexagonalOrdinal(triangular) + " = P" + getPentagonalOrdinal(triangular));
        }
    }
    
    public static long getTriangular(long n){
        return (long)((float)(n*(n+1)/2));
    }
    public static long getPentagonal(long n){
        return (long)((float)(n*(3*n-1)/2));
    }
    public static long getHexagonal(long n){
        return (long)((float)(n*(2*n-1)));
    }
    
    public static long getTriangularOrdinal(long n){
        if(!isTriangular(n)) return 0;
        long i = 1;
        while(true){
            long triangular = getTriangular(i++);
            if(n == triangular) return --i;
        }
    }
    
    public static long getPentagonalOrdinal(long n){
        if(!isPentagonal(n)) return 0;
        long i = 1;
        while(true){
            long pentagonal = getPentagonal(i++);
            if(n == pentagonal) return --i;
        }
    }
    public static long getHexagonalOrdinal(long n){
        if(!isHexagonal(n)) return 0;
        long i = 1;
        while(true){
            long hexagonal = getHexagonal(i++);
            if(n == hexagonal) return --i;
        }
    }
    
    public static boolean isTriangular(long n){
        long i = 0;
        while(true){
            long triangular = getTriangular(i++);
            if(n == triangular) return true;
            if( triangular > n ) return false;
        }
    }
    public static boolean isPentagonal(long n){
        long i = 0;
        while(true){
            long pentagonal = getPentagonal(i++);
            if(n == pentagonal) return true;
            if( pentagonal > n ) return false;
        }
    }
    public static boolean isHexagonal(long n){
        long i = 0;
        while(true){
            long hexagonal = getHexagonal(i++);
            if(n == hexagonal) return true;
            if( hexagonal > n ) return false;
        }
    }
    
}
