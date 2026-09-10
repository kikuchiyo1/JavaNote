import java.util.*;

public class Main {
    // x储存哨兵的位置 y标记已经被哨兵监视的位置 m行数 n列数
    static int[][] x;
    static int[][] y;
    static int m, n, minSentinel, ansCount, k;
    static HashSet<String> solutions; // 用于去重
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        x = new int[m+2][n+2];
        y = new int[m+2][n+2];
        // 经验估算最少哨兵数量，同时在边界上围一圈便于处理边界情况
        minSentinel = m*n/3+2;
        ansCount = 0;
        k = 0;
        solutions = new HashSet<>();
        for(int i = 0;i <= m+1;i++) {
            y[i][0] = 1;
            y[i][n+1] = 1;
        }
        for(int i = 0;i <= n+1;i++) {
            y[0][i] = 1;
            y[m+1][i] = 1;
        }
        search(1, 1);
        System.out.println(minSentinel);
        System.out.println(ansCount);
    }
    // 设置哨兵
    public static void setSentinel(int i,int j) {
        x[i][j] = 1;
        k++;
        y[i][j+1]++;
        y[i+1][j]++;
        y[i][j]++;
        y[i][j-1]++;
        y[i-1][j]++;
    }
    // 移除哨兵
    public static void removeSentinel(int i,int j) {
        x[i][j] = 0;
        k--;
        y[i][j+1]--;
        y[i+1][j]--;
        y[i][j]--;
        y[i][j-1]--;
        y[i-1][j]--;
    }
    // 生成当前解的字符串表示
    public static String getSolutionKey() {
        StringBuilder sb = new StringBuilder();
        for (int r = 1; r <= m; r++)
            for (int c = 1; c <= n; c++)
                if (x[r][c] == 1)
                    sb.append(r).append(",").append(c).append(";");
        return sb.toString();
    }
    // 搜索 - 找到第一个未被监视的位置，强制在能覆盖它的位置中选一个放哨兵
    public static void search(int i, int j) {
        // 找到第一个未被监视的位置
        while (i <= m && y[i][j] > 0) {
            j++;
            if (j > n) {
                i++;
                j = 1;
            }
        }
        
        // 所有位置都被监视了
        if (i > m) {
            if (k < minSentinel) {
                minSentinel = k;
                ansCount = 1;
                solutions.clear();
                solutions.add(getSolutionKey());
            } else if (k == minSentinel) {
                if (solutions.add(getSolutionKey())) {
                    ansCount++;
                }
            }
            return;
        }
        
        // 最优性剪枝：只有超过已知最小值时才剪枝
        if (k > minSentinel) return;

        // 可行性剪枝：计算未覆盖的位置数
        int uncovered = 0;
        for (int r = i; r <= m; r++) {
            for (int c = (r == i ? j : 1); c <= n; c++) {
                if (y[r][c] == 0) uncovered++;
            }
        }
        // 每个哨兵最多覆盖5个位置，如果当前哨兵数+最少还需要的哨兵数 > minSentinel，剪枝
        if (k + (uncovered + 4) / 5 > minSentinel) return;
        
        // 位置(i,j)未被监视，必须在能覆盖它的位置中选择
        // 考虑所有5个可能的位置：(i,j), (i-1,j), (i+1,j), (i,j-1), (i,j+1)
        
        // 选择1：在(i-1,j)放置哨兵
        if (i > 1) {
            setSentinel(i - 1, j);
            search(i, j);
            removeSentinel(i - 1, j);
        }
        
        // 选择2：在(i,j-1)放置哨兵
        if (j > 1) {
            setSentinel(i, j - 1);
            search(i, j);
            removeSentinel(i, j - 1);
        }
        
        // 选择3：在(i,j)放置哨兵
        setSentinel(i, j);
        search(i, j);
        removeSentinel(i, j);
        
        // 选择4：在(i+1,j)放置哨兵
        if (i < m) {
            setSentinel(i + 1, j);
            search(i, j);
            removeSentinel(i + 1, j);
        }
        
        // 选择5：在(i,j+1)放置哨兵
        if (j < n) {
            setSentinel(i, j + 1);
            search(i, j);
            removeSentinel(i, j + 1);
        }
    }
}
