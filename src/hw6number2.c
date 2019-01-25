/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

int main()
{
    int month, day, year, item_num;
    float unit_price;
    
    printf("Enter Item Number: ");
    scanf("%d",&item_num);
    
    printf("Enter Unit Price: ");
    scanf("%f",&unit_price);
    
    printf("Enter a date (mm/dd/yyyy): ");
    scanf("%d/%d/%d", &month, &day, &year);
    
    printf("\nItem\t\tUnit\t\tPurchase\n\t\tPrice\t\tDate\n");
    printf("%d\t\t$%7.2f\t%.2d/%.2d/%d\n\n", item_num, unit_price, month, day, year);

    return 0;
}
