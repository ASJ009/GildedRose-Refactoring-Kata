package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    /**
     * Test case to check if the conjured items degrades quality twice as fast as normal items
     * 
     */
    @Test
    void testConjuredItems() {
    	int quality = 10;
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 10) };
        GildedRose app = new GildedRose(items);
        while(items[0].sellIn > 0) { 
        	app.updateQuality();
        	quality -= 2; // for every passing day the quality should be reduced by 2
        	assertEquals(quality, app.items[0].quality);
        }
    }
    
    /**
     * Test case to check if the conjured items quality is never negative
     * 
     */
    @Test
    void testConjuredItemsForMinimumQuality() {
    	int quality = 4;
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 4) };
        GildedRose app = new GildedRose(items);
        while(items[0].sellIn > 0) { 
        	app.updateQuality();
        	quality -= 2; // for every passing day the quality should be reduced by 2, once negative it should always be 0
        	if(quality < 0) {
        		quality = 0;
        	}
        	assertEquals(quality, app.items[0].quality);
        }
    }
}