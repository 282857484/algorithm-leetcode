package com.leecode.algorithm.interview;

import java.util.*;

/**
 * 任务 1
 * 我们希望你实现 task1() 这个函数, 它把 rows 中所 有满足 b >= 10 && b < 50 并且 a == 1000 || a == 2000 || a == 3000 的行 的内容都打印到终端.
 * Row
 * {
 * int a;
 * int b;
 * } ;
 *
 * Task 1.
 *
 * Find out all the rows that sastify below conditions:
 *
 *     ((b >= 10 && b < 50) &&
 *      (a == 1000 || a == 2000 || a == 3000))
 *
 * Print them to the terminal, one row per line, for example:
 *
 * 1000,20
 * 1000,23
 * 2000,16
 *
 * 任务 2
 * 在任务 1的基础上,如果输入的参数 rows 已经按照(a,b)进行过排序,想 办法对 task1()的执行性能进行优化.示例输入:
 * Row sorted_rows[]=
 * The total number of rows.
 * The rows,for example rows[0]is the first row.

 * 任务 3
 * 在任务 2的基础上,我们期望你打印出的匹配行是按照 b 列进行排序的,请 尽量优化函数的执行性能.示例输出:
 * 1000,10
 * 2000,10
 * 2000,10
 * 1000,11
 * 2000,12
 * 任务 4
 * 基于任务 3,如果 a 列上的匹配条件不只是 1000,2000,3000,而是扩充成 1000,2000,3000,...,98000,99000,你在任务 3中进行的实现是否足够优化,是否有更好的优化手段?
 */
public class Siwei {
    /**
     * result:
     *
     * 1000,20
     * 2000,23
     * 3000,16
     * ----------------------
     * 1000,20
     * 2000,23
     * 3000,15
     * 3000,16
     * 3000,14
     * ----------------------
     * 3000,14
     * 3000,15
     * 3000,16
     * 1000,20
     * 2000,23
     * ----------------------
     * 3000,14
     * 3000,15
     * 3000,16
     * 4000,16
     * 1000,20
     * 2000,23
     * ----------------------
     * 3000,14
     * 3000,15
     * 3000,16
     * 4000,16
     * 1000,20
     * 2000,23
     * ----------------------
     *
     * Process finished with exit code 0
     * @param args
     */
    public static void main(String[] args) {
        Siwei Siwei = new Siwei();
        Siwei.task1(new Row[]{new Row(1000,20),new Row(2000,23),new Row(3000,16)},0);
        System.out.println("----------------------");
        Siwei.task2(new Row[]{
                new Row(998,20),new Row(999,20),new Row(999,20),
                new Row(1000,20),new Row(2000,23),new Row(3000,16)
                ,new Row(3000,15),new Row(3000,14),new Row(4000,16)
        },0);
        System.out.println("----------------------");
        Siwei.task3(new Row[]{
                new Row(998,20),new Row(999,20),new Row(999,20),
                new Row(1000,20),new Row(2000,23),new Row(3000,16)
                ,new Row(3000,15),new Row(3000,14),new Row(4000,16)
        },0);
        System.out.println("----------------------");
        Siwei.task4_1(new Row[]{
                new Row(998,20),new Row(999,20),new Row(999,20),
                new Row(1000,20),new Row(2000,23),new Row(3000,16)
                ,new Row(3000,15),new Row(3000,14),new Row(4000,16)
        },0, new int[] {1000,2000,3000,4000});
        System.out.println("----------------------");
        Siwei.task4_2(new Row[]{
                new Row(998,20),new Row(999,20),new Row(999,20),
                new Row(1000,20),new Row(2000,23),new Row(3000,16)
                ,new Row(3000,15),new Row(3000,14),new Row(4000,16)
        },0, new int[] {1000,2000,3000,4000});
        System.out.println("----------------------");
    }

    public void task1(Row[] rows, int nrows) {
        for (int i = 0; i < rows.length; i++) {
            if ((rows[i].a == 1000 || rows[i].a == 2000 || rows[i].a == 3000)
                    && (rows[i].b > 10 && rows[i].b < 50)) {
                System.out.println(rows[i].a + "," + rows[i].b);
            }
        }
    }

    public void task2(Row[] rows, int nrows) {
        int[] targets = new int[]{1000, 2000, 3000};
        for (int targetA : targets) {
            int pos = binarySearch(rows, targetA);
            justiceBAndPrint(rows[pos]);
            if (pos > -1) {
                int l = pos - 1;
                int r = pos + 1;
                while (l > -1) {
                    if (rows[l].a == targetA) {
                        justiceBAndPrint(rows[l]);
                    } else {
                        break;
                    }
                    l--;
                }
                while (r < rows.length) {
                    if (rows[r].a == targetA) {
                        justiceBAndPrint(rows[r]);
                    } else {
                        break;
                    }
                    r++;
                }
            }
        }
    }

    private void justiceBAndPrint(Row rows) {
        if (rows.b > 10 && rows.b < 50) {
            System.out.println(rows.a + "," + rows.b);
        }
    }

    private int binarySearch(Row[] rows, int target) {
        int left = 0;
        int right = rows.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (rows[mid].a == target) {
                return mid;
            } else if (rows[mid].a < target) {
                left = mid + 1;
            } else if (rows[mid].a > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public void task3(Row[] rows, int nrows) {
        int[] targets = new int[]{1000, 2000, 3000};
        for (int targetA : targets) {
            int pos = binarySearch(rows, targetA);
            extractedAdd(rows[pos]);
            if (pos > -1) {
                int l = pos - 1;
                int r = pos + 1;
                while (l > -1) {
                    if (rows[l].a == targetA) {
                        extractedAdd(rows[l]);
                    } else {
                        break;
                    }
                    l--;
                }
                while (r < rows.length) {
                    if (rows[r].a == targetA) {
                        extractedAdd(rows[r]);
                    } else {
                        break;
                    }
                    r++;
                }
            }
        }
        list.sort((x, y) -> x.b - y.b);
        for (Row row : list) {
            System.out.println(row.a + "," + row.b);
        }
    }

    List<Row> list = new ArrayList<>();

    private void extractedAdd(Row rows) {
        if (rows.b > 10 && rows.b < 50) {
            list.add(rows);
        }
    }

    /**
     * 任务四主要看数据分布情况：
     * 根据特性使用相应的方法
     */
    /**
     * 先找a,再判断b
     *
     * @param rows
     * @param nrows
     * @param target
     */
    public void task4_1(Row[] rows, int nrows, int[] target) {
        HashMap<Integer, LinkedList<Row>> map = new HashMap<>();
        for (int i = 0; i < rows.length; i++) {
            if (map.containsKey(rows[i].a)) {
                map.get(rows[i].a).add(rows[i]);
            } else {
                LinkedList<Row> l = new LinkedList<Row>();
                l.add(rows[i]);
                map.put(rows[i].a, l);
            }
        }
        LinkedList<Row> result = new LinkedList<>();
        for (int t : target) {
            if (map.containsKey(t)) {
                result.addAll(map.get(t));
            }
        }
        result.sort((x, y) -> x.b - y.b);
        for (Row row : result) {
            justiceBAndPrint(row);
        }
    }

    /**
     *
     * 以b为条件
     * 红黑树，存储时key是有序聚集的，范围取数据
     *
     * @param rows
     * @param nrows
     * @param target
     */
    public void task4_2(Row[] rows, int nrows, int[] target) {
        Map<Integer, Boolean> tm = new HashMap();
        for (int t : target) {
            tm.put(t, true);
        }
        TreeMap<Integer, LinkedList<Row>> map = new TreeMap<>();
        for (int i = 0; i < rows.length; i++) {
            if (map.containsKey(rows[i].b)) {
                map.get(rows[i].b).add(rows[i]);
            } else {
                LinkedList<Row> l = new LinkedList<Row>();
                l.add(rows[i]);
                map.put(rows[i].b, l);
            }
        }
        LinkedList<Row> result = new LinkedList<>();
        // b > 10 && b <50
        SortedMap<Integer, LinkedList<Row>> nMap = map.subMap(10, 50);
        for (LinkedList<Row> lr : nMap.values()) {
            result.addAll(lr);
        }
        for (Row row : result) {
            if (tm.containsKey(row.a)) {
                System.out.println(row.a + "," + row.b);
            }
        }
    }

    static class Row implements Comparable<Row> {
        int a;
        int b;

        public Row(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Row o) {
            return this.b - o.b;
        }
    }
}
