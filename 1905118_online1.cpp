#include <iostream>
using namespace std;

class Random {
    int row=0,col=0,minim=0,maxa=0;
    int** mat=NULL;
    public:
    Random(int r,int c,int mn,int mx) {
        row=r;
        col=c;
        minim=mn;
        maxa=mx;
        mat=(int**) malloc (row*sizeof(int*));
        for(int i=0;i<r;i++) {
            mat[i]=(int*) malloc (col*sizeof(int));
        }
    }
    ~Random() {
        for(int i=0;i<row;i++) {
            free(mat[i]);
        }
        free(mat);
    }
    void print() {
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                cout<<mat[i][j]<<' ';
            }
            cout<<'\n';
        }
    }
    void randomize() {
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                mat[i][j]=rand()%(maxa-minim+1)+minim;
            }
        }
    }
    int get(int r,int c) {
        if(r<row && c<col) {
            return mat[r][c];
        }
    }
    void add(int n) {
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                mat[i][j]+=n;
            }
        }
    }
    int add() {
        int sum=0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                sum+=mat[i][j];
            }
        }
        return sum;
    }
};

int main()
{
 cout<<"Hello World"<<'\n';
 Random m(3,3,100,200);
 m.randomize();
 m.print();
 cout<<m.get(0,0)<<'\n';
 m.add(100);
 m.print();
 cout<<m.add()<<'\n';

 return 0;
}