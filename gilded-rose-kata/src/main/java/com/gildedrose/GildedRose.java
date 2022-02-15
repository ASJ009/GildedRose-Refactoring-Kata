package com.gildedrose;

class GildedRose {
    Item[] items;

    public static enum ItemNames {
    	AGED_BRIE("Aged Brie"), SULFARUS("Sulfuras, Hand of Ragnaros"), BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
    	CONJURED("Conjured Mana Cake"), DEFAULT(""); 
    	
	    public String itemDescription;
	
		ItemNames(String itemDescription) {
			this.itemDescription = itemDescription;
		}
		
		public String getDesc() {
			return this.itemDescription;
		}

		public static ItemNames get(String desc) {
			for(ItemNames item : ItemNames.values()) {
				if(item.itemDescription.equals(desc)) {
					return item;
				}
			}
			return ItemNames.DEFAULT;
		}
		
    }
    
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	if (!ItemNames.SULFARUS.getDesc().equals(items[i].name)) {
                items[i].sellIn = items[i].sellIn - 1;
            }
        	
        	switch(ItemNames.get(items[i].name)) {
        		case AGED_BRIE : 
        			if (this.items[i].quality < 50) {
        	            this.items[i].quality += 1;
        	            if(this.items[i].sellIn < 0) {
        	            	this.items[i].quality += 1;
            			}
        	            if (this.items[i].quality > 50) {
            	        	this.items[i].quality = 50;
            	        }
        	        }
        			break;
        		case BACKSTAGE : 
        			if (this.items[i].sellIn < 0) {
        	            this.items[i].quality = 0;
        	        } else if (this.items[i].sellIn < 6) {
        	            this.items[i].quality += 3;
        	        } else if (this.items[i].sellIn < 11) {
        	            this.items[i].quality += 2;
        	        } else {
        	            this.items[i].quality += 1;
        	        }
        	        if (this.items[i].quality > 50) {
        	        	this.items[i].quality = 50;
        	        }
        	        break;
        		case SULFARUS : 
        			this.items[i].quality = 80;
        			break;
        		case CONJURED : 
        			if (this.items[i].quality > 0) {
        	            this.items[i].quality -= 2;
        	            if(this.items[i].sellIn < 0) {
        	            	this.items[i].quality -= 2;
            			}
        	            if (this.items[i].quality < 0) {
            	        	this.items[i].quality = 0;
            	        }
        	        }
        			break;
        		default : 
        			if (this.items[i].quality > 0) {
        	            this.items[i].quality -= 1;
        	            if(this.items[i].sellIn < 0) {
        	            	this.items[i].quality -= 1;
            			}
        	            if(this.items[i].quality < 0) {
            				this.items[i].quality = 0;
            			}
        	        }
        			break;
        	}
        }
    }
}