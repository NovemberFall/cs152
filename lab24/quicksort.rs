fn main(){
    let mut nums = [9, 4, 13, 2, 22, 17, 8, 9, 1];

    let left = 0;
    let right = nums.len() - 1;
    quick_sort(&mut nums[..], left, right);

    print_sorted_array(&nums[..]);

}

fn quick_sort(nums: &mut[i32], left:usize, right:usize){
    if left > right {
        return;
    }

    let pivot_pos = partition(nums, left, right);
    if pivot_pos == 0{
        return;
    }
    quick_sort(nums, left, pivot_pos-1);
    quick_sort(nums, pivot_pos+1, right);
}

fn partition(nums: &mut[i32], left:usize, right:usize) -> usize{
    if right <= left {
        return right;
    }

    let piovt = right;
    let mut index = left;
    for j in left..right{
        if nums[j] <= nums[piovt] {
            nums.swap(index, j);
            index += 1;
        }
    }
    nums.swap(index, right);
    return index;
}


fn print_sorted_array(nums: &[i32]) -> (){
    for i in nums{
        print!("{}, ", i);
    }
}