#include <iostream>

#include <cmath>

using namespace std;
class Point {
    // x and y coordinate
    int x, y;

public:
    //Add necessary constructor(s) to initialize x and y
    //Add your set and get functions for x and y
    Point()
    {
        x = 0;
        y = 0;
        // to avoid garbage values
    }
    Point(int a, int b)
    {
        x = a;
        y = b;
    }
    int getx()
    {
        return x;
    }
    int gety()
    {
        return y;
    }
    void set(int a, int b)
    {
        x = a;
        y = b;
    }

    void print()
    {
        cout << "Coordinate: " << x << ", " << y << endl;
    }
};
class Line {
    Point p1, p2;

public:
    Line(int a1, int b1, int a2, int b2)
    {
        p1.set(a1, b1);
        p2.set(a2, b2);
    }
    void length()
    {
        double a, b;
        a = 1.0 * (p1.getx() - p2.getx());
        b = 1.0 * (p1.gety() - p2.gety());
        a = a * a + b * b;
        a = sqrt(a);
        cout << "Length: " << a << endl;
    }
};
class Circle {
    Point p;
    int radius;

public:
    // Add necessary constructor(s) to initialize p and radius
    // Overload “upload” functions
    Circle(int a, int b, int r)
    {
        p.set(a, b);
        radius = r;
    }
    void update(int a, int b)
    {
        int cc, dd;
        cc = p.getx();
        dd = p.gety();
        p.set(cc + a, dd + b);
    }
    void update(int a)
    {
        radius += a;
    }
    void update(int a, int b, int c)
    {
        radius += c;
        int cc, dd;
        cc = p.getx();
        dd = p.gety();
        p.set(cc + a, dd + b);
    }
    void print()
    {
        cout << "Center ";
        p.print();
        cout << "Radius: " << radius << endl;
    }
};
int main()
{
    Point p(5, 5);
    Circle c(2, 3, 5);
    cout << endl
         << "Point Display" << endl;
    p.print();
    cout << endl
         << "Circle Display" << endl;
    c.print();
    cout << endl;

    //First update
    cout << "First Update" << endl;
    // call “update” function of Circle class to increase the center’s x coordinate by 5 and y coordinate by 5;
    c.update(5, 5);
    c.print();
    cout << endl;

    //Second update
    cout << "Second Update" << endl;

    // call “update” function of Circle class to increase the radius by 6;
    c.update(6);
    c.print();
    cout << endl;

    //Third update
    cout << "Third Update" << endl;

    // call “update” function of Circle class to increase the center’s x coordinate by 2 and y coordinate by 2 and the radius by 2;
    c.update(2, 2, 2);
    c.print();
    cout << endl;
    cout << "Line Display" << endl;
    Line L(3, 6, 9, 4);
    L.length();
    return 0;
}