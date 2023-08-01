public class Dictionary {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,34,32,23,12,2,56};//我们需要的是升序数组
        Dictionary d = new Dictionary();
//        d.bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        d.print(nums);
        System.out.println();

//        System.out.println(d.dichotomySearch(nums, 23));
        int left = 0,right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == 23) {
                System.out.println(nums[mid]);
                break;
            } else if (nums[mid] > 23) {
                right = mid - 1;
            } else left = mid + 1;
        }
    }


    // TODO 下面这个方法是经典排序之一的冒泡排序
//    public void bubbleSort(int[] arrays) {
//        for (int i = 1; i < arrays.length; i++) {
//            for (int j = 0; j < arrays.length - 1; j++) {
//                if (arrays[j] > arrays[j + 1]) {
//                    int temp = arrays[j];
//                    arrays[j] = arrays[j + 1];
//                    arrays[j + 1] = temp;
//                }
//            }
//        }
//    }

    /**
     * 打印数组
     * @param arrays
     */
    public void print(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + "\t");
        }
    }



    // TODO 给定一个n 个元素有序的（升序）整型数组 nums 和一个目标值target  ，写一个函数搜索 nums 中的 target，
    //  如果目标值存在返回下标，否则返回 -1。
//    public int dichotomySearch(int[] nums, int target) {
//
//        int left = 0, right = nums.length - 1;
//        while (left <= right) {
//        int mid = (right - left) / 2 + left;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] > target) {
//                right = mid - 1;
//            } else left = mid + 1;
//        }
//        return -1;
//    }



}

