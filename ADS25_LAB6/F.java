import java.io.*;
import java.util.*;

public class F {
    static Map<String, Double> mp = new HashMap<>();
    static {
        mp.put("A+", 4.00);
        mp.put("A", 3.75);
        mp.put("B+", 3.50);
        mp.put("B", 3.00);
        mp.put("C+", 2.50);
        mp.put("C", 2.00);
        mp.put("D+", 1.50);
        mp.put("D", 1.00);
        mp.put("F", 0.00);
    }

    static class Student {
        String last;
        String first;
        double gpa;
        Student(String l, String f, double g) {
            last = l;
            first = f;
            gpa = g;
        }
    }

    static boolean comp(Student a, Student b) {
        if (a.gpa > b.gpa) return true;
        if (a.gpa < b.gpa) return false;
        int c1 = a.last.compareTo(b.last);
        if (c1 < 0) return true;
        if (c1 > 0) return false;
        return a.first.compareTo(b.first) < 0;
    }

    static int partition(List<Student> ar, int left, int right) {
        Student pivot = ar.get(right);
        int index = left;
        for (int i = left; i < right; i++) {
            if (comp(ar.get(i), pivot)) {
                Collections.swap(ar, i, index);
                index++;
            }
        }
        Collections.swap(ar, index, right);
        return index;
    }

    static void quick_sort(List<Student> ar, int left, int right) {
        if (left < right) {
            int p = partition(ar, left, right);
            quick_sort(ar, left, p - 1);
            quick_sort(ar, p + 1, right);
        }
    }

    static double sumgpa(Scanner sc, int subjects) {
        double sumMark = 0, sumCredit = 0;
        for (int i = 0; i < subjects; i++) {
            String mark = sc.next();
            int credit = sc.nextInt();
            sumMark += mp.get(mark) * credit;
            sumCredit += credit;
        }
        return sumMark / sumCredit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String last = sc.next();
            String first = sc.next();
            int subj = sc.nextInt();
            double gpa = sumgpa(sc, subj);
            students.add(new Student(last, first, gpa));
        }

        quick_sort(students, 0, students.size() - 1);

        for (Student s : students) {
            System.out.printf(Locale.US, "%s %s %.3f%n", s.last, s.first, s.gpa);
        }
    }
}
