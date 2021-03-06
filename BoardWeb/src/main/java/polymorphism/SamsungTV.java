package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
    private int price;
    
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public SamsungTV() {
		System.out.println("=====> SamsungTV  객체 생성");
	}

	public SamsungTV(Speaker speaker) {
		System.out.println("====>SamsunTV(2) 객체 생성");
		this.speaker = speaker;
	}

	public void powerOn() {
		System.out.println("SamsungTV-- 전원 켠다." +"가격:" + price);
	}

	public void powerOff() {
		System.out.println("SamsunTV-- 전원 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
