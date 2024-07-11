public class AnimalListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AnimalAdapter animalAdapter;
    private List<Animal> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        animalList = new ArrayList<>();
        animalList.add(new Animal("Lion", R.drawable.lion, "The lion is a large cat of the genus Panthera native to Africa and India."));
        animalList.add(new Animal("Tiger", R.drawable.tiger, "The tiger is the largest living cat species and a member of the genus Panthera."));
        animalList.add(new Animal("Elephant", R.drawable.elephant, "Elephants are the largest existing land animals."));
        animalList.add(new Animal("Giraffe", R.drawable.giraffe, "The giraffe is an African artiodactyl mammal, the tallest living terrestrial animal."));
        animalList.add(new Animal("Crocodile", R.drawable.crocodile, "Crocodiles are large semiaquatic reptiles that live throughout the tropics."));

        animalAdapter = new AnimalAdapter(this, animalList);
        recyclerView.setAdapter(animalAdapter);
    }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
        case R.id.menu_info:
            startActivity(new Intent(this, ZooInformationActivity.class));
            return true;
        case R.id.menu_uninstall:
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}

}
