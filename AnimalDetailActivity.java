public class AnimalDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        ImageView animalImage = findViewById(R.id.animal_image);
        TextView animalName = findViewById(R.id.animal_name);
        TextView animalDescription = findViewById(R.id.animal_description);

        Intent intent = getIntent();
        String name = intent.getStringExtra("animal_name");
        int image = intent.getIntExtra("animal_image", 0);
        String description = intent.getStringExtra("animal_description");

        animalName.setText(name);
        animalImage.setImageResource(image);
        animalDescription.setText(description);
    }
}
