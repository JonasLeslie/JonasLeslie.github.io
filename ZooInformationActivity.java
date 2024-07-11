public class ZooInformationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_information);

        TextView zooPhone = findViewById(R.id.zoo_phone);
        zooPhone.setOnClickListener(v -> {
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:888-8888"));
            startActivity(dialIntent);
        });
    }
}
