/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, PHP, HTML, CSS, JS
Code, Compile, Run and Debug online from anywhere in world.

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
    int a[] = { 2, 19, 1, 5, 0, -5, 4, 11, 7};
    int i;
    int n = 9;
    
    
    for(i = 0; i < n; i++){
        printf("%d ", a[i]);
    }
    printf("\n");
    quicksort(a,0,8);
    
    for(i = 0; i < n; i++){
        printf("%d ", a[i]);
    }
    printf("\n");
    
    
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


void quicksort(int *arr, int low, int high)
{
  int pivot, i, j, temp;
  if(low < high) {
    pivot = low; //pivot 
    i = low;
    j = high;
    while(i < j) {// increment i till you get a number greater than the pivot 
      while(arr[i] <= arr[pivot] && i <= high)
        i++;// decrement j till you get a number less than the pivot 
      while(arr[j] > arr[pivot] && j >= low)
        j--;// if i < j swap the elements 
      if(i < j) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    
    temp = arr[j];
    arr[j] = arr[pivot];
    arr[pivot] = temp;
    // Repeat quicksort
    quicksort(arr, low, j-1);
    quicksort(arr, j+1, high);
  }
}


