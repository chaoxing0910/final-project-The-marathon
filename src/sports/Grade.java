package sports;

public class Grade implements Comparable<Grade>{
		private Competition competition;
		private User user;
		private double grade;
		private int rank;
		public Competition getCompetition() {
			return competition;
		}
		public void setCompetition(Competition competition) {
			this.competition = competition;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public double getGrade() {
			return grade;
		}
		public void setGrade(double grade) {
			this.grade = grade;
		}
		public int getRank() {
			return rank;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}
		@Override
		public int compareTo(Grade o) {
			return (int) (o.getGrade()-this.grade);
		}
}
