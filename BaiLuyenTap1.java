package baitap;

import java.util.Arrays;
import java.util.Scanner;

public class BaiLuyenTap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[100];
        int currentIndex = 0;
        do{
            System.out.println("************************MENU**************************");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong mảng (k nhập từ bàn phím)");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần, \n các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần,\n các phần tử còn lại ở giữa mảng theo thứ tự tăng dần");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nhập vào n: ");
                    int n = scanner.nextInt();
                    System.out.println("Nhập vào giá trị các phần tử");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("arr[%d] = ", currentIndex);
                        arr[currentIndex] = scanner.nextInt();
                        currentIndex++;
                    }
                    break;
                case 2:
                    System.out.println("Giá trị các phần tử trong mảng");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%5d", arr[i]);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Trung bình các phần tử dương trong mảng: ");
                    int sum = 0, count = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (arr[i] > 0) {
                            sum += arr[i];
                            count++;
                        }
                    }
                    System.out.printf("%.2f\n", count == 0 ? 0 : (double) sum / count);
                    break;
                case 4:
                    System.out.print("Nhập giá trị k cần tìm: ");
                    int k = scanner.nextInt();
                    System.out.print("Vị trí các phần tử có giá trị bằng K: ");
                    boolean isfound = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if(arr[i] == k){
                            System.out.printf("%3d", i);
                            isfound = true;
                        }
                    }
                    System.out.println();
                    if(!isfound){
                        System.out.printf("Không tìm thấy phần tử có giá trị bằng %d trong mảng",k);
                    }
                    break;
                case 5:
                    for (int i = 0; i < currentIndex - 1; i++) {
                        for (int j = 0; j < currentIndex - i - 1; j++) {
                            if (arr[j] < arr[j + 1]) {
                                int temp = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Mảng sau khi sắp xếp giảm dần: ");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%5d", arr[i]);
                    }
                    System.out.println();
                    break;
                case 6:
                    int primeCount = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        boolean isPrime = true;
                        if (arr[i] <= 1) continue;
                        for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                            if (arr[i] % j == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                        if (isPrime) primeCount++;
                    }
                    System.out.println("Số lượng phần tử là số nguyên tố: " + primeCount);
                    break;
                case 7:
                    int[] evenDiv3 = new int[currentIndex];
                    int[] oddDiv3 = new int[currentIndex];
                    int[] others = new int[currentIndex];
                    int evenCount = 0, oddCount = 0, otherCount = 0;

                    for (int i = 0; i < currentIndex; i++) {
                        if (arr[i] % 2 == 0 && arr[i] % 3 == 0) {
                            evenDiv3[evenCount++] = arr[i];
                        } else if (arr[i] % 2 != 0 && arr[i] % 3 == 0) {
                            oddDiv3[oddCount++] = arr[i];
                        } else {
                            others[otherCount++] = arr[i];
                        }
                    }

                    Arrays.sort(evenDiv3, 0, evenCount);
                    Arrays.sort(oddDiv3, 0, oddCount);
                    for (int i = 0; i < oddCount / 2; i++) {
                        int temp = oddDiv3[i];
                        oddDiv3[i] = oddDiv3[oddCount - 1 - i];
                        oddDiv3[oddCount - 1 - i] = temp;
                    }
                    Arrays.sort(others, 0, otherCount);
                    System.out.println("Mảng sau khi sắp xếp:");
                    for (int i = 0; i < evenCount; i++) {
                        System.out.printf("%5d", evenDiv3[i]);
                    }
                    for (int i = 0; i < otherCount; i++) {
                        System.out.printf("%5d", others[i]);
                    }
                    for (int i = 0; i < oddCount; i++) {
                        System.out.printf("%5d", oddDiv3[i]);
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.print("Nhập giá trị m cần chèn: ");
                    int m = scanner.nextInt();
                    int insertIndex = 0;
                    while (insertIndex < currentIndex && arr[insertIndex] > m) {
                        insertIndex++;
                    }
                    for (int i = currentIndex; i > insertIndex; i--) {
                        arr[i] = arr[i - 1];
                    }
                    arr[insertIndex] = m;
                    currentIndex++;
                    System.out.println("Mảng sau khi chèn giá trị " + m + ": ");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%5d", arr[i]);
                    }
                    System.out.println();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                    break;
            }
        } while (true);
    }
}
