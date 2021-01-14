package home.inheritance.binding;

class Tester {
	
	public static void main(String[] args) {
		//AbstractUpper up = new AbstractUpper(); wrong
		AbstractUpper abMid = new Middle();
		AbstractUpper abLow = new Lower();
		AbstractUpper abBot = new Bottom();
		
		Middle midLow = new Lower();
		Lower lowBot = new Bottom();
		Middle midBot = new Bottom();
		Bottom bot = new Bottom();
		
		/*
		midLow.talk(lowBot); //selects talk(lower), lower speaks
		abBot.talk(midBot); //selects talk(Abstract), bottom speaks
		abBot.talk(bot); //selects talk(lower), lower speaks
		midBot.talk(lowBot);
		bot.talk(bot);
		*/
		
		General general = new Extension();
		general.calc(4);
		General gen2 = new ExtraExtension();
		//gen2.calc(5.4);
		Extension e = new Extension();
		//e.calc(4.14);
		
		abMid.calculate(3);
		midLow.calculate('t');
		//abMid.talk(midLow); //error because talk doesn't exists in the superclass

	}
	
}
