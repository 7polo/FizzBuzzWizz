# FizzBuzzWizz
### 环境
+ win
+ jdk1.8

---

### 运行步骤
+ 下载 https://github.com/7polo/FizzBuzzWizz/blob/master/out/artifacts/Question_jar/Question.jar
+ 将cmd切换到 jar的路径下, 运行

```
javar -jar Question.jar
```
+ 按要求输入

![](https://github.com/7polo/FizzBuzzWizz/blob/master/out/%E6%88%AA%E5%9B%BE.PNG)
---

### 思路
+ 采用策略模式， 学生与策略建立联系， HashMap<Student, IStrategy>
  + IStratage -- 抽象接口
    + NormalStrategy 输出数字
    + FirstStrategy 输出 Fizz
    + ..
    + FirstSecondStrategy 输出 FizzBuzz
    + ...
    + HighestStartegy 包含第一个特殊数字的策略类，输出 Fizz
    
+ 为普通属性的 student 注册 普通的策略类
+ 为 固有倍数关系的 student 的注册倍数策略
+ 为 特殊属性的 student 注册 HighestStartegy 策略

---
#### 核心代码
+ 倍数关系的策略绑定
```
    public static TreeMap<Integer, IStrategy> bindStrategy(int[] array) {
        TreeMap<Integer, IStrategy> map = new TreeMap<>();
        map.put(1, new NormalStartegy()); //最基础的
        map.put(array[0], new FirstStrategy());
        map.put(array[1], new SecondStrategy());
        map.put(array[2], new ThirdStrategy());
        map.put(array[0] * array[1], new FirstSecondStartegy());
        map.put(array[0] * array[2], new FirstThirdStartegy());
        map.put(array[1] * array[2], new SecondThirdStartegy());
        map.put(array[0] * array[1] * array[2], new ALLStartegy());
        return map;
    }
 ```
 
 + 添加学生, 按策略添加
    + 根据HashMap的属性，存在的元素 value 会覆盖，实现策略覆盖
 ```
    private void addStrategy() {
        strategyMap = Tools.bindStrategy(array); //数字与策略绑定
        //倍数策略
        for (Map.Entry<Integer, IStrategy> entry : strategyMap.entrySet()) {
            int index = entry.getKey(); //基数
            IStrategy strategy = entry.getValue();
            for (int j = 1; index * j <= maxSize; j++) { //按倍率添加
                stuMap.put(new Student(index * j), strategy);
            }
        }

        // 特殊策略 包含第一个数字的
        IStrategy strategy = new HighestStartegy();  // 最高的策略
        for (int i = 0; i < 10; i++) {
            //array[0]0 - array[0]9 如 40 - 49
            stuMap.put(new Student(array[0] * 10 + i), strategy);

            //0array[0] - 9array[0] 如： 04， 14， 24..94
            stuMap.put(new Student(i * 10 + array[0]), strategy);
        }
    }
   ```
