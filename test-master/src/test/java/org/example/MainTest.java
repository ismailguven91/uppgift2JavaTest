package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    ArrayList<Coordinate> coordinates;

    @BeforeEach
    void setUp() {
        coordinates = new ArrayList<>();
    }

    @Test
    void No_Points_Return_None() {
        String actual = Main.getFigure(coordinates);
        assertEquals("None", actual);
    }

    @Test
    void One_Point_Return_Dot() {
        coordinates.add(new Coordinate(1, 5, 0));
        String actual = Main.getFigure(coordinates);
        assertEquals("Dot", actual);
    }

    @Test
    void Two_Points_Return_Line() {
        coordinates.add(new Coordinate(0, 0, 0));
        coordinates.add(new Coordinate(2, 6, 0));
        String actual = Main.getFigure(coordinates);

        assertEquals("Line", actual);
    }

    @Test
    void Three_Points_Return_Triangle() {
        coordinates.add(new Coordinate(0, 0, 0));
        coordinates.add(new Coordinate(1, 5, 0));
        coordinates.add(new Coordinate(2, 8, 0));
        String actual = Main.getFigure(coordinates);

        assertEquals("Triangle", actual);
    }

    @Test
    void Four_XYPoints_Forming_Square_Should_Return_Square() {
        coordinates.add(new Coordinate(1, 1, 0));
        coordinates.add(new Coordinate(1, 4, 0));
        coordinates.add(new Coordinate(4, 4, 0));
        coordinates.add(new Coordinate(4, 1, 0));
        String actual = Main.getFigure(coordinates);

        assertEquals("Square", actual);
    }

    @Test
    void Four_XZPoints_Forming_Square_Should_Return_Square() {
        coordinates.add(new Coordinate(1, 0, 1));
        coordinates.add(new Coordinate(1, 0, 4));
        coordinates.add(new Coordinate(4, 0, 4));
        coordinates.add(new Coordinate(4, 0, 1));
        String actual = Main.getFigure(coordinates);

        assertEquals("Square", actual);
    }

    @Test
    void Four_YZPoints_Forming_Square_Should_Return_Square() {
        coordinates.add(new Coordinate(0, 1, 1));
        coordinates.add(new Coordinate(0, 1, 4));
        coordinates.add(new Coordinate(0, 4, 4));
        coordinates.add(new Coordinate(0, 4, 1));
        String actual = Main.getFigure(coordinates);

        assertEquals("Square", actual);
    }


    @Test
    void Four_Unordered_Points_Forming_Square_Should_Return_2D() {
        coordinates.add(new Coordinate(1, 4, 0));
        coordinates.add(new Coordinate(1, 1, 0));
        coordinates.add(new Coordinate(4, 4, 0));
        coordinates.add(new Coordinate(4, 1, 0));

        String actual = Main.getFigure(coordinates);
        assertEquals("2D shape", actual);
    }

    @Test
    void Four_Points_Forming_Rectangle_Should_Return_Rectangle() {
        coordinates.add(new Coordinate(6, 2, 0));
        coordinates.add(new Coordinate(6, 4, 0));
        coordinates.add(new Coordinate(2, 4, 0));
        coordinates.add(new Coordinate(2, 2, 0));

        String actual = Main.getFigure(coordinates);

        assertEquals("Rectangle", actual);
    }

    @Test
    void Four_Unordered_Points_forming_Rectangle_Should_Return_2D_Shape() {
        coordinates.add(new Coordinate(2, 4, 0));
        coordinates.add(new Coordinate(6, 2, 0));
        coordinates.add(new Coordinate(2, 2, 0));
        coordinates.add(new Coordinate(6, 4, 0));


        String actual = Main.getFigure(coordinates);

        assertEquals("2D shape", actual);
    }

    @Test
    void Four_Points_Shaping_A_Parallelogram_Should_Return_Parallelogram() {
        coordinates.add(new Coordinate(10, 1, 0));
        coordinates.add(new Coordinate(1, 1, 0));
        coordinates.add(new Coordinate(8, 6, 0));
        coordinates.add(new Coordinate(17, 6, 0));
        String actual = Main.getFigure(coordinates);

        assertEquals("Parallelogram", actual);
    }

    @Test
    void Four_Unordered_Points_Forming_Parallelogram_Should_Return_2D_Shape() {
        coordinates.add(new Coordinate(10, 1, 0));
        coordinates.add(new Coordinate(8, 6, 0));
        coordinates.add(new Coordinate(17, 6, 0));
        coordinates.add(new Coordinate(1, 1, 0));

        String actual = Main.getFigure(coordinates);

        assertEquals("2D shape", actual);
    }

    @Test
    void A_2D_Shape_With_4_points_With_No_Recognizable_Shape_Should_Return_2D() {

        coordinates.add(new Coordinate(1, 1, 0));
        coordinates.add(new Coordinate(2, 2, 0));
        coordinates.add(new Coordinate(3, 3, 0));
        coordinates.add(new Coordinate(4, 4, 0));

        String actual = Main.getFigure(coordinates);

        assertEquals("2D shape", actual);

    }

    @Test
    void A_2D_Shape_With_5_points_With_No_Recognizable_Shape_Should_Return_2D() {

        coordinates.add(new Coordinate(1, 1, 0));
        coordinates.add(new Coordinate(2, 2, 0));
        coordinates.add(new Coordinate(3, 3, 0));
        coordinates.add(new Coordinate(4, 4, 0));
        coordinates.add(new Coordinate(5, 5, 0));

        String actual = Main.getFigure(coordinates);

        assertEquals("2D shape", actual);

    }

    @Test
    void A_2D_Shape_With_6_points_With_No_Recognizable_Shape_Should_Return_2D() {

        coordinates.add(new Coordinate(1, 1, 0));
        coordinates.add(new Coordinate(2, 2, 0));
        coordinates.add(new Coordinate(3, 3, 0));
        coordinates.add(new Coordinate(4, 4, 0));
        coordinates.add(new Coordinate(5, 5, 0));
        coordinates.add(new Coordinate(6, 6, 0));

        String actual = Main.getFigure(coordinates);

        assertEquals("2D shape", actual);

    }

    @Test
    void Five_Points_Shaping_A_Pyramid_Should_Return_Pyramid(){

        coordinates.add(new Coordinate(-1, -1, 0));
        coordinates.add(new Coordinate(-1, 1, 0));
        coordinates.add(new Coordinate(1, 1, 0));
        coordinates.add(new Coordinate(1, -1, 0));
        coordinates.add(new Coordinate(0, 0, 1));
        String actual = Main.getFigure(coordinates);

        assertEquals("Pyramid", actual);
    }

    @Test
    void A_3D_Shape_With_3_points_With_No_Recognizable_Shape_Should_Return_3D() {

        coordinates.add(new Coordinate(1, 1, 1));
        coordinates.add(new Coordinate(1, 1, 0));
        coordinates.add(new Coordinate(2, 2, 0));

        String actual = Main.getFigure(coordinates);

        assertEquals("3D shape", actual);

    }

    @Test
    void A_3D_Shape_With_4_points_With_No_Recognizable_Shape_Should_Return_3D() {

        coordinates.add(new Coordinate(1, 1, 1));
        coordinates.add(new Coordinate(1, 1, 0));
        coordinates.add(new Coordinate(2, 2, 0));
        coordinates.add(new Coordinate(3, 2, 0));

        String actual = Main.getFigure(coordinates);

        assertEquals("3D shape", actual);

    }

    @Test
    void A_3D_Shape_With_5_points_With_No_Recognizable_Shape_Should_Return_3D() {

        coordinates.add(new Coordinate(1, 1, 1));
        coordinates.add(new Coordinate(1, 1, 1));
        coordinates.add(new Coordinate(2, 2, 0));
        coordinates.add(new Coordinate(3, 3, 0));
        coordinates.add(new Coordinate(4, 4, 0));

        String actual = Main.getFigure(coordinates);

        assertEquals("3D shape", actual);

    }
}