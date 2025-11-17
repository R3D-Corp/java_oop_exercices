package util;

public class Vector {


    
    public static Vector3 multiplyVectors(Vector3 v1, Vector3 v2) {
        return new Vector3(v1.getX() * v2.getX(), v1.getY() * v2.getY(), v1.getZ() * v2.getZ());
    }

    public static Vector3 multiplyByFactor(Vector3 v, float factor) {
        return new Vector3(v.getX() * factor, v.getY() * factor, v.getZ() * factor);
    }

    public static Vector3 multiplyVector2ByVector3(Vector3 v1, Vector2 v2) {
        return new Vector3(v1.getX() * v2.getX(), v1.getY() * v2.getY(), v1.getZ());
    }


    public static class Vector2 {

        private float componentX, componentY;

        private void setX(float x) {this.componentX = x;}
        private void setY(float y) {this.componentY = y;}

        public float getX() {return this.componentX;}
        public float getY() {return this.componentY;}

        public Vector2 add(Vector2 v) {
            this.setX(this.getX() + v.getX());
            this.setY(this.getY() + v.getY());

            return this;
        }

        public Vector2 sub(Vector2 v) {
            this.setX(this.getX() - v.getX());
            this.setY(this.getY() - v.getY());

            return this;
        }
        
        public float norm() {
            return (float)Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
        }

        public Vector3 toVector3() { return new Vector3(this.getX(), this.getY(), 0);}
        
        public static Vector3 toVector3(Vector2 v) { return new Vector3(v.getX(), v.getY(), 0);}

        public static Vector2 multiplyVectors(Vector2 v1, Vector2 v2) {
            return new Vector2(v1.getX() * v2.getX(), v1.getY() * v2.getY());
        }

        public static Vector2 fromString(String vector) {
            vector = vector.trim().replace("(", "").replace(")", "");
            String[] parts = vector.split(",");
            
            if(parts.length != 2) throw new IllegalArgumentException("Votre vecteur ne contient pas 2 composantes distinctes");
            
            try {
                float x = Float.parseFloat(parts[0].trim());
                float y = Float.parseFloat(parts[1].trim());
                
                return new Vector2(x, y);
                
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public Vector2(float X, float Y) {
            this.setX(X);
            this.setY(Y);
        }
    
        public Vector2(double X, double Y) {
            this((float)X, (float)Y);
        }
    
        public Vector2(int X, int Y) {
            this((float)X, (float)Y);
        }
    }

    public static class Vector3 {

        private float componentX, componentY, componentZ;

        private void setX(float x) {this.componentX = x;}
        private void setY(float y) {this.componentY = y;}
        private void setZ(float z) {this.componentZ = z;}

        public float getX() {return this.componentX;}
        public float getY() {return this.componentY;}
        public float getZ() {return this.componentZ;}

        
        public static Vector3 fromString(String vector) {
            vector = vector.trim().replace("(", "").replace(")", "");
            String[] parts = vector.split(",");
            
            if(parts.length != 3) throw new IllegalArgumentException("Votre vecteur ne contient pas 3 composantes distinctes");
            
            try {
                float x = Float.parseFloat(parts[0].trim());
                float y = Float.parseFloat(parts[1].trim());
                float z = Float.parseFloat(parts[2].trim());
                
                return new Vector3(x, y, z);
                
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException(e);
            }
        }
        
        public Vector3(float X, float Y, float Z) {
            this.setX(X);
            this.setY(Y);
            this.setZ(Z);
        }
    
        public Vector3(double X, double Y, double Z) {
            this((float)X, (float)Y, (float)Z);
        }
    
        public Vector3(int X, int Y, int Z) {
            this((float)X, (float)Y, (float)Z);
        }

        public Vector2 toVector2() { return new Vector2(this.componentX, this.componentY);}

    }


}

    // public static Vector transform(String vector) {
    //     vector = vector.trim().replace("(", "").replace(")", "");

    //     String[] parts = vector.split(",");
        
    //     if(parts.length != 2) return new Vector(0, 0);
        
    //     try {
            
    //         double x = Double.parseDouble(parts[0].trim());
    //         double y = Double.parseDouble(parts[1].trim());

    //         return new Vector(x, y);
    //     } catch(NumberFormatException e) {
    //         return new Vector(0, 0);
    //     }
    // }