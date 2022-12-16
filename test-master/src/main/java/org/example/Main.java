package org.example;

import java.util.ArrayList;

public class Main {

    static double DistAB = 0;
    static double DistBC = 0;
    static double DistDC = 0;
    static double DistAD = 0;
    static double slopeAB = 0;
    static double slopeBC = 0;
    static double slopeDC = 0;
    static double slopeAD = 0;

    public static void main(String[] args) {
    }
    public static String getFigure(ArrayList<Coordinate> coordinates) {

        //0 coordinates.
        if (coordinates.size() == 0) {
            System.out.println("None");
            return "None";
        }

        double x = coordinates.get(0).getX();
        double y = coordinates.get(0).getY();
        double z = coordinates.get(0).getZ();
        boolean X_2D = false;
        boolean Y_2D = false;
        boolean Z_2D = false;

        for (var item : coordinates) {
            if (item.getZ() != z) {
                Z_2D = true;
            }
            if (item.getX() != x) {
                X_2D = true;
            }
            if (item.getY() != y) {
                Y_2D = true;
            }
        }

        //check if 2D
        if (!X_2D || !Y_2D || !Z_2D) {

            //1 coordinate.
            if (coordinates.size() == 1) {
                System.out.println("Dot");
                return "Dot";
            }

            //2 coordinates.
            else if (coordinates.size() == 2) {
                System.out.println("Line");
                return "Line";
            }

            //3 coordinates.
            else if (coordinates.size() == 3) {
                System.out.println("Triangle");
                return "Triangle";
            }

            //4 coordinates.
            else if (coordinates.size() == 4) {

                double[] A = {coordinates.get(0).getX(), coordinates.get(0).getY(), coordinates.get(0).getZ()};
                double[] B = {coordinates.get(1).getX(), coordinates.get(1).getY(), coordinates.get(1).getZ()};
                double[] C = {coordinates.get(2).getX(), coordinates.get(2).getY(), coordinates.get(2).getZ()};
                double[] D = {coordinates.get(3).getX(), coordinates.get(3).getY(), coordinates.get(3).getZ()};

                if (!Z_2D) {
                    DistAB = Math.round(calcDist(A[0], A[1], B[0], B[1]));
                    DistBC = Math.round(calcDist(B[0], B[1], C[0], C[1]));
                    DistDC = Math.round(calcDist(D[0], D[1], C[0], C[1]));
                    DistAD = Math.round(calcDist(A[0], A[1], D[0], D[1]));
                    slopeAB = calcIncline(B[0], B[1], A[0], A[1]);
                    slopeBC = calcIncline(A[0], A[1], C[0], C[1]);
                    slopeDC = calcIncline(D[0], D[1], C[0], C[1]);
                    slopeAD = calcIncline(B[0], B[1], D[0], D[1]);

                } else if (!Y_2D) {
                    DistAB = Math.round(calcDist(A[0], A[2], B[0], B[2]));
                    DistBC = Math.round(calcDist(B[0], B[2], C[0], C[2]));
                    DistDC = Math.round(calcDist(D[0], D[2], C[0], C[2]));
                    DistAD = Math.round(calcDist(A[0], A[2], D[0], D[2]));
                    slopeAB = calcIncline(B[0], B[2], A[0], A[2]);
                    slopeBC = calcIncline(A[0], A[2], C[0], C[2]);
                    slopeDC = calcIncline(D[0], D[2], C[0], C[2]);
                    slopeAD = calcIncline(B[0], B[2], D[0], D[2]);

                } else {
                    DistAB = Math.round(calcDist(A[1], A[2], B[1], B[2]));
                    DistBC = Math.round(calcDist(B[1], B[2], C[1], C[2]));
                    DistDC = Math.round(calcDist(D[1], D[2], C[1], C[2]));
                    DistAD = Math.round(calcDist(A[1], A[2], D[1], D[2]));
                    slopeAB = calcIncline(B[1], B[2], A[1], A[2]);
                    slopeBC = calcIncline(A[1], A[2], C[1], C[2]);
                    slopeDC = calcIncline(D[1], D[2], C[1], C[2]);
                    slopeAD = calcIncline(B[1], B[2], D[1], D[2]);
                }


                //square
                if (DistAB == DistBC && DistBC == DistDC && DistDC == DistAD) {
                    System.out.println("Square");
                    return "Square";
                    //rectangle or parallelogram
                } else if (DistAB == DistDC && DistAD == DistBC) {
                    //rectangle
                    if (Double.isInfinite(slopeAB) || Double.isInfinite(slopeBC) || Double.isInfinite(slopeDC) || Double.isInfinite(slopeAD)) {
                        System.out.println("Rectangle");
                        return "Rectangle";
                    }
                    //parallelogram
                    else {
                        System.out.println("Parallelogram");
                        return "Parallelogram";
                    }
                } else {
                    System.out.println("2D shape");
                    return "2D shape";
                }
            }
            System.out.println("2D shape");
            return "2D shape";
        }

        if (X_2D || Y_2D || Z_2D) {

            if (coordinates.size() == 5) {

                double[] A = {coordinates.get(0).getX(), coordinates.get(0).getY(), coordinates.get(0).getZ()};
                double[] B = {coordinates.get(1).getX(), coordinates.get(1).getY(), coordinates.get(1).getZ()};
                double[] C = {coordinates.get(2).getX(), coordinates.get(2).getY(), coordinates.get(2).getZ()};
                double[] D = {coordinates.get(3).getX(), coordinates.get(3).getY(), coordinates.get(3).getZ()};

                DistAB = Math.round(calcDist(A[0], A[1], B[0], B[1]));
                DistBC = Math.round(calcDist(B[0], B[1], C[0], C[1]));
                DistDC = Math.round(calcDist(D[0], D[1], C[0], C[1]));
                DistAD = Math.round(calcDist(A[0], A[1], D[0], D[1]));

                if (DistAB == DistBC && DistBC == DistDC && DistDC == DistAD || (DistAB == DistDC && DistAD == DistBC)) {
                    System.out.println("Pyramid");
                    return "Pyramid";
                }
                System.out.println("3D shape");
                return "3D shape";
            }
            System.out.println("3D shape");
            return "3D shape";
        }
        return null;
    }
    public static double calcIncline(double x1, double y1, double x2, double y2) {
        return (y2 - y1) / (x2 - x1);
    }
    public static double calcDist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(2, x2 - x1) + Math.pow(2, y2 - y1));
    }
}