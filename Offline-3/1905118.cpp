#include<iostream>

#include<cstring>

using namespace std;

class Vector {
    char * name;
    int x, y, z;
    public:
        Vector(char * n) {
            int l = strlen(n);
            name = new char[l + 1];
            strcpy(name, n);
            x = 0;
            y = 0;
            z = 0;
        }
    Vector(char * n, int a, int b, int c) {
        int l = strlen(n);
        name = new char[l + 1];
        strcpy(name, n);
        x = a;
        y = b;
        z = c;
    }

    int setX(int a) {
        x = a;
    }
    int setY(int b) {
        y = b;
    }
    int setZ(int c) {
        z = c;
    }

    void setName(char * n) {
        int l = strlen(n);
        name = new char[l + 1];
        strcpy(name, n);
    }

    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
    int getZ() {
        return z;
    }

    char * getName() {
            return name;
        }

        ~Vector() {
            delete[] name;
        }
    Vector & operator = (const Vector & v) {
        x = v.x;
        y = v.y;
        z = v.z;
        return *this;
    }
    void print() {
        cout << name << ": ";
        cout << x << 'x';
        if (y >= 0) {
            cout << '+' << y << 'y';
        } else {
            cout << y << 'y';
        }
        if (z >= 0) {
            cout << '+' << z << 'z';
        } else {
            cout << z << 'z';
        }
        cout << '\n';
    }
    int operator == (Vector & v) {
        return ((x == v.x) && (y == v.y) && (z == v.z));
    }
    Vector operator * (Vector & v) {
        Vector temp("");
        temp.x = this -> x * v.x;
        temp.y = this -> y * v.y;
        temp.z = this -> z * v.z;
        return temp;
    }
    Vector operator ^ (Vector & v) {
        Vector temp("");
        temp.x = (this -> y * v.z) - (this -> z * v.y);
        temp.y = (this -> z * v.x) - (this -> x * v.z);
        temp.z = (this -> x * v.y) - (this -> y * v.x);
        return temp;
    }
    friend Vector operator * (int a, Vector & v);
    friend Vector operator * (Vector & v, int a);

};

Vector operator * (int a, Vector & v) {
    Vector temp("");
    temp.x = v.x * a;
    temp.y = v.y * a;
    temp.z = v.z * a;
    return temp;
}
Vector operator * (Vector & v, int a) {
    Vector temp("");
    temp.x = v.x * a;
    temp.y = v.y * a;
    temp.z = v.z * a;
    return temp;
}

int main() {
    Vector v1("v1", 1, 2, 3), v2("v2", 4, 5, -6), v3("Result1"), v4("Result2", -27, 18, -3);

    v1.print(); ///Print the components of vector v1
    v2.print(); ///Print the components of vector v2

    v3 = v1 ^ v2; ///Calculate the cross product of vector v1 and vector v2 (Consider ^ as cross product for this assignment)
    v3.print(); ///Print the modified components of vector v3 (Name: Result1)

    if (v3 == v4) ///Check for equality; if two vectors contain equal component values (x, y, z), then they are equal.
        cout << "Vectors are equal" << endl;
    else
        cout << "Vectors are not equal" << endl;

    v1 = v1 * 2; ///Multiply each component of vector v1 with the given value
    v1.print(); ///Print the modified components of vector v1

    v2 = 2 * v2; ///Multiply each component of vector v2 with the given value
    v2.print(); ///Print the modified components of vector v2

    v3 = v1 * v2; ///Multiply each component of vector v1 with the corresponding component of vector v2.
    v3.print(); ///Print the modified components of vector v3 (Name: Result1)

    if (v3 == v4) ///Check for equality; if two vectors contain equal component values (x, y, z), then they are equal.
        cout << "Vectors are equal" << endl;
    else
        cout << "Vectors are not equal" << endl;

    return 0;
}