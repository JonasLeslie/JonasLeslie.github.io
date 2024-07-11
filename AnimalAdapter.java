public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    private List<Animal> animalList;
    private Context context;

    public AnimalAdapter(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_animal, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = animalList.get(position);
        holder.animalName.setText(animal.getName());
        holder.animalThumbnail.setImageResource(animal.getThumbnail());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, AnimalDetailActivity.class);
            intent.putExtra("animal_name", animal.getName());
            intent.putExtra("animal_image", animal.getThumbnail());
            intent.putExtra("animal_description", animal.getDescription());

            if (position == animalList.size() - 1) {
                new AlertDialog.Builder(context)
                        .setTitle("Warning")
                        .setMessage("This animal is very scary. Do you want to proceed?")
                        .setPositiveButton("Yes", (dialog, which) -> context.startActivity(intent))
                        .setNegativeButton("No", null)
                        .show();
            } else {
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        ImageView animalThumbnail;
        TextView animalName;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            animalThumbnail = itemView.findViewById(R.id.animal_thumbnail);
            animalName = itemView.findViewById(R.id.animal_name);
        }
    }
}
