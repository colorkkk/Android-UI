@[TOC](实验三)

# Android UI组件



## 1.Android ListView的用法

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190409103039114.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjQxNDEy,size_16,color_FFFFFF,t_70)
public class MainActivity extends AppCompatActivity {
    private List<Map<String, Object>> listItems;
    private String[] names = new String[]
            {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] imageIds = new int[]
            {R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
                    R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("ListView");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainui);
        listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("animalName", names[i]);
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.animals_layout,
                new String[]{"animalName", "image"},
                new int[]{R.id.animals_name, R.id.animals_image});
AnimalsAdapter(AnimalsActivity.this,R.layout.animals_layout,animalsList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_SHORT).show();
         Toast.makeText(AnimalsActivity.this,animals.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190409103806420.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjQxNDEy,size_16,color_FFFFFF,t_70)
## 2.创建自定义布局的AlertDialog
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019040910341619.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjQxNDEy,size_16,color_FFFFFF,t_70)

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("AlterDialog");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog builder = new AlertDialog.Builder(MainActivity2.this)
                        .setView(R.layout.dialog_layout)
                        .setNegativeButton("Cancel",null)
                        .setPositiveButton("Sign in",null)
                        .create();
                builder.show();
            }
        });
    }
}
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190409103819816.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjQxNDEy,size_16,color_FFFFFF,t_70)
## 3.使用XML定义菜单
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190409103626645.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjQxNDEy,size_16,color_FFFFFF,t_70)
public class MainActivity3 extends AppCompatActivity {
    public static final String TAG = "lifecycle";
    float size[] = {40, 50, 60};
    String color[] = {"red", "black"};
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Log.d(TAG, "oncreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        textView = findViewById(R.id.textView);
        switch (item.getItemId()) {
            case R.id.item_1:
                textView.setTextSize(size[0]);
                return true;
            case R.id.item_2:
                textView.setTextSize(size[1]);
                return true;
            case R.id.item_3:
                textView.setTextSize(size[2]);
                return true;
            case R.id.item2:
                Toast.makeText(this, textView.getText(), Toast.LENGTH_SHORT).show();
            case R.id.item3_1:
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                return true;
            case R.id.item3_2:
                textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                return true;
        }
        return true;
    }
}
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190409103829731.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjQxNDEy,size_16,color_FFFFFF,t_70)
## 4.创建上下文操作模式(ActionMode)的上下文菜单
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019040910371714.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjQxNDEy,size_16,color_FFFFFF,t_70)
public class MainActivity4 extends AppCompatActivity {
    private ListView list;
    private String[] names = new String[]
            { "One", "Two", "Three", "Four","Five"};
    private int[] images = new int[]{
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background ,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
    };

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        this.setTitle("ActionMode");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionmode);
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", images[i]);
            listItem.put("Name", names[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        final android.widget.SimpleAdapter simpleAdapter = new android.widget.SimpleAdapter(this, listItems,
                R.layout.sim,
                new String[] { "image", "Name",},
                new int[] { R.id.header,R.id.name });
        list = (ListView) findViewById(R.id.mlist);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);

        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // 第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
            }
        });
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.main_menu2, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(android.view.ActionMode mode) {
            }

            @Override
            public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public void onItemCheckedStateChanged(android.view.ActionMode mode, int position,
                                                  long id, boolean checked) {
                mode.setSubtitle(list.getCheckedItemCount()+"selected");
            }

            @Override
            public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
                mode.finish();
                return false;
            }
        });
    }
}
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190409103839373.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjQxNDEy,size_16,color_FFFFFF,t_70)
