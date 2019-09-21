package hello01;

public class CompactDiscs {

		private String title;
		private String artist;

		public CompactDiscs() {
			super();
			System.out.println("CompactDisc的无参构造方法"+this.toString());
		}
		public CompactDiscs(String title, String artist) {
			this.title=title;
			this.artist=artist;
			System.out.println("CompactDisc的有参构造方法"+this.toString());
		}
		public void play() {
			System.out.println("播放CD音乐...."+this.toString()+" "+this.title+" by "+this.artist);
	}
}
