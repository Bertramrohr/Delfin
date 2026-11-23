public class Team {
        private String type; // F.eks. "Ungdom" eller "Senior"
        private Trainer trainer;

        public Team(String type, Trainer trainer) {
            this.type = type;
            this.trainer = trainer;
        }

        public String getType() {
            return type;
        }

        public Trainer getTrainer() {
            return trainer;
        }

        @Override
        public String toString() {
            return "Hold: " + type + " (Træner: " + (trainer != null ? trainer.getName() : "Ingen") + ")";
        }
}
