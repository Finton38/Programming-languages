/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>
#include<string.h>
#define MAX 2
struct student
{
    char name[20];
    char cls[20];
    int age;
    float gpa;
    
};

int main()
{
    struct student arr_student[MAX];
    int i;
    
    for(i = 0; i < MAX; i++ ){
        printf("What is your Name?\n");
        scanf("%s", arr_student[i].name);
        
        printf("What is your age?\n");
        scanf("%d", &arr_student[i].age);
        
        printf("Enter GPA\n");
        scanf("%f", &arr_student[i].gpa);
        
        printf("Are you a Freshman, Sophmore, Junior, or Senior?\n");
        scanf("%s", &arr_student[i].cls);
}
    
    
    for(i = 0; i < MAX; i++ )
    {
        printf("%s\t%d\t%.2f\t%s\n",
        arr_student[i].name, arr_student[i].age, arr_student[i].gpa, arr_student[i].cls);
    }

    return 0;
}





