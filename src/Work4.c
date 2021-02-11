#include <stdio.h>

void print_arr(float arr[], int size) {
    printf("[");
    for(int i = 0; i < size; i++) {
        if(i == (size-1)) printf("%.2f", arr[i]);
        else printf("%.2f, ", arr[i]);
    }
    printf("]\n");
}

float knapsack(int n, float it_w[], float it_p[], int M) {
    float sum_price = 0;
    for (int i = 0; i < n && M > 0; i++)
    {
        if(it_w[i] < M) {
            sum_price += it_p[i];
            M -= (int) it_w[i];
        } else {
            sum_price += ((float) M/it_w[i])*(it_p[i]);
            M -= M;
        }
        printf("[%d] SumOfPrice: %.2f (%.2f + %.2f) \n    RemainInBag: %d (%.0f - %.0f)\n",(i+1), sum_price,(sum_price - it_p[i]), it_p[i], M, (M+it_w[i]), it_w[i]);
        printf("|-- Price = %.0f Weight = %.0f (PPW = %.2f)\n", it_p[i], it_w[i], (it_p[i]/it_w[i]));
    }
    return sum_price;
}

int main() {
    printf("==========================================\n");
    printf("== Knapsack problem using greedy method ==\n");
    printf("==========================================\n");
    int num_it = 0, M = 45;
    printf("Number item(s) => "); scanf(" %d", &num_it);
    float it_p[num_it], it_w[num_it], ppw[num_it], temp = 0;
    printf("Item(s) Price (%d) => ", num_it);
    for (int i = 0; i < num_it; i++) scanf(" %f", &it_p[i]);
    printf("Item(s) Weight (%d) => ", num_it);
    for (int i = 0; i < num_it; i++) scanf(" %f", &it_w[i]);

    /*num_it = 5;
    float it_p[] = {92,21,51,21,90};
    float it_w[] = {8,13,12,15,20};
    float ppw[num_it];
    float temp = 0;*/

    for(int i = 0; i < num_it; i++) ppw[i] = it_p[i] / it_w[i];
    printf("Inputed Data:\n");
    printf("Item Price = "); print_arr(it_p, num_it);
    printf("Item Weight = "); print_arr(it_w, num_it);
    printf("Price per Weight = "); print_arr(ppw, num_it);
    //Sorting Max -> Min
    for (int i = 0; i < num_it; i++) {
        for (int j = i + 1; j < num_it; j++) {
            if (ppw[i] < ppw[j]) {
                //=== Swaping ===
                //Price per Weight
                temp = ppw[j];
                ppw[j] = ppw[i];
                ppw[i] = temp;
                //Items Weight
                temp = it_w[j];
                it_w[j] = it_w[i];
                it_w[i] = temp;
                //Items Price
                temp = it_p[j];
                it_p[j] = it_p[i];
                it_p[i] = temp;
                // ==============
            }
        }
    }
    printf("Sorted:\n");
    printf("Item Price = "); print_arr(it_p, num_it);
    printf("Item Weight = "); print_arr(it_w, num_it);
    printf("Price per Weight = "); print_arr(ppw, num_it);
    printf("\nBag Capacity: %d \n", M);
    printf("Maximum of Possible Summations Price = %.2f", knapsack(num_it, it_w, it_p, M));
}
