package com.example.demo.test;

import java.util.Arrays;

/**
 * 快速排序法
 * 
 * @author Java
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] array = { 6, 2, 4, 8, 9, 5, 7, 3, 1, 10 };
		System.out.println("排序之前的数组: " + Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println("排序之后的数组: " + Arrays.toString(array));
	}

	private static void quickSort(int[] array, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			// 找基准元素
			System.out
					.println("找基准前数组: " + Arrays.toString(array) + "startIndex:" + startIndex + "endIndex:" + endIndex);
			int baseIndex = divide(array, startIndex, endIndex);
			System.out.println("找基准后数组: " + baseIndex + ":" + Arrays.toString(array));

			// 递归调用,对分隔后的左边数组快速排序
			quickSort(array, startIndex, baseIndex - 1);
			System.out.println(baseIndex + "前段基准后:" + Arrays.toString(array));

			// 递归调用,对分隔后的右边数组快速排序
			quickSort(array, baseIndex + 1, endIndex);
			System.out.println(baseIndex + "后段基准后:" + Arrays.toString(array));

		} else {
			return;
		}
	}

	/**
	 * 利用双边循环法分隔数组
	 *
	 * @param array
	 *            需要排序的数组
	 * @param startIndex
	 *            数组的开始下标
	 * @param endIndex
	 *            数组的结束下标
	 * @return 返回分隔点所在的位置
	 */
	private static int divide(int[] array, int startIndex, int endIndex) {
		// 用数组的第一个元素作为起始元素
		int base = array[startIndex];
		int i = startIndex;
		int j = endIndex;
		while (i != j) {
			// 从右向左寻找第一个小于基准数的值
			while (i < j && array[j] > base) {
				j--;
			}
			// 从左向右寻找第一个大于基准数的值
			while (i < j && array[i] <= base) {
				i++;
			}
			// 交换位置
			if (i < j) {
				swap(array, i, j);
			}
		}

		// 指针i 与指针j 相遇，把重合点的元素与基准元素交换位置
		array[startIndex] = array[i];
		array[i] = base;

		// 返回分隔点所在的位置
		return i;
	}

	/**
	 * 交换i 与 j 位置的值
	 *
	 * @param array
	 * @param i
	 * @param j
	 */
	private static void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
