#include <iostream>
using namespace std;


///Copy the modified inventory class from the solved Problem 4 program
///Write an appropriate definition of buyer class.

///Write an appropriate definition of seller class.

class inventory
{
    static int count;
public:
    inventory(){cout<<"Parameter-less constructor for inventory class object"<<endl;}
    inventory(int c){cout<<"Parameterized constructor for inventory class object"<<endl; count = c;}
    int get_count(){return count;}
    int set_count(int c){count = c;}
    void changeInventory(int c){cout<<"To be changed by the derived classes";}
    void show(){cout<<"To be changed by the derived classes";}
    ~inventory(){cout<<"Destructor for inventory class object"<<endl;}
};

int inventory::count=0;

class buyer : public inventory 
{
    static int so_far_bought;
    public:
    buyer() {
        cout<<"Parameter-less constructor for buyer class object"<<'\n';
    }
    ~buyer() {
        cout<<"Destructor for buyer class object"<<'\n';
    }
    void changeInventory(int val) {
        so_far_bought+=val;
        set_count(get_count()+val);
    }
    void show() {
        cout<<"So far bought quantity: " <<so_far_bought<<'\n';
        cout<<"Available in inventory: "<<get_count()<<'\n';
    }
};

int buyer :: so_far_bought=0;

class seller : public inventory 
{
    static int so_far_sold;
    public:
    seller() {
        cout<<"Parameter-less constructor for seller class object"<<'\n';
    }
    ~seller() {
        cout<<"Destructor for seller class object"<<'\n';
    }
    void changeInventory(int val) {
        so_far_sold+=val;
        set_count(get_count()-val);
    }
    void show() {
        cout<<"So far sold quantity: " <<so_far_sold<<'\n';
        cout<<"Available in inventory: "<<get_count()<<'\n';
    }
};

int seller :: so_far_sold=0;

int main()
{
    int option, quantity, person;
    buyer b1, b2;
    seller s1, s2;
    cout<<"Enter option 1 to buy, option 2 to sell, and other to exit"<<endl;

    while(1)
    {
        cout<<"Option: ";
        cin>>option;
        if(option==1)
        {
            cout<<"Quantity: ";
            cin>>quantity;
            cout<<"Person (1 or 2): ";
            cin>>person;
            if(person==1)
            {
                b1.changeInventory(quantity);
                b1.show();
            }
            else
            {
                b2.changeInventory(quantity);
                b2.show();
            }

        }
        else if(option == 2)
        {
            cout<<"Quantity: ";
            cin>>quantity;
            cout<<"Person (1 or 2): ";
            cin>>person;
            if(person==1)
            {
                s1.changeInventory(quantity);
                s1.show();
            }
            else
            {
                s2.changeInventory(quantity);
                s2.show();
            }
        }
        else
            break;
    }

    return 0;
}
