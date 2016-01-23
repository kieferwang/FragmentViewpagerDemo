# FragmentViewpagerDemo

实现的功能
1、滑动的同时改变标题栏
2、点击标题栏的同时滑动
3、点击fragment中的button能有toast提示

实现过程：
1、设置好4个fragment，让他们关联其布局文件。
2、为viewpager设置FragmentPagerAdapter。在其中放入每个item中的fragment以及总共的item的个数。
3、为viewpgaer绑定时间监听器，设置在item变化的时候会调用的方法，也就是在滑动的时候会发生的事件。（在demo中item改变时会改变底部button中的字体的颜色）
4、为底部button实现点击事件，事实上就是在点击之后改变viewpgaer中的item，一行解决。
5、为fragment中的button设置toast的点击效果。
