## 513.找树左下角的值

![img.png](img.png)

### 思路: `DFS` 深度优先搜索 先找左节点，用深度标记 
### `BFS` 广度优先 先找同层的节点 然后同层节点从右往左遍历 最后结束深度的节点的值就是最左节点， JAVA里可以用队列实现