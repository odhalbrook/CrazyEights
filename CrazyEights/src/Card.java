
public class Card
	{
		public String number;
		public String suit;
		public int value;
		
		public Card(String n, String s, int v)
		{
			number = n;
			suit = s;
			value = v;
		}

		public String getNumber()
			{
				return number;
			}

		public void setNumber(String number)
			{
				this.number = number;
			}

		public String getSuit()
			{
				return suit;
			}

		public void setSuit(String suit)
			{
				this.suit = suit;
			}

		public int getValue()
			{
				return value;
			}

		public void setValue(int value)
			{
				this.value = value;
			}
		
	}
