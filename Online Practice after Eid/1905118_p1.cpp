#include <iostream>
#include <cstring>

using namespace std;

namespace infrastructure {
    class pool {
        int height,width,depth;
        char painted_color[10];
        public:
        void set_properties(int h,int w,int d,char *pc) {
            height = h;
            width = w;
            depth = d;
            strcpy(painted_color,pc);
        }
        void show() {
            cout<<"Height : "<<height<<'\n';
            cout<<"Width : "<<width<<'\n';
            cout<<"Depth : "<<depth<<'\n';
            cout<<"Painted Color : "<<painted_color<<'\n';
        }
    };
}

namespace sports {
    class pool {
        char table_ingredient[20],table_color[10];
        public:
        void set_properties(char *ti,char *tc) {
            strcpy(table_ingredient,ti);
            strcpy(table_color,tc);
        }
        void show() {
            cout<<"Table Ingredients : "<<table_ingredient<<'\n';
            cout<<"Table Color : "<<table_color<<'\n';
        }
    };
}

int main() {
    infrastructure :: pool ob1;
    ob1.set_properties(1,2,3,"Blue");
    ob1.show();
    sports :: pool ob2;
    ob2.set_properties("Stick and Ball","Green");
    ob2.show();
    return 0;
}