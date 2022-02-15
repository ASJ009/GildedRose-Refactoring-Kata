package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 2, 14), // once the sellIn in negative quality degrades twice as fast
                new Item("Aged Brie", 2, 0), // increases in quality the older it gets
                new Item("Elixir of the Mongoose", 5, 7), // quality is reduced by one as sellIn reduces
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), // quality is never altered
                new Item("Sulfuras, Hand of Ragnaros", -1, 80), // quality is never altered
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), // quality increases by 1 when sellIn is greater than 10
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30), // quality increases by 2 when sellIn is between 6-10
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30), // quality increases by 3 when sellIn is greater than 0-5
                new Item("Backstage passes to a TAFKAL80ETC concert", 2, 30), // quality drops to 0 when sellIn is less than 0
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) }; // quality decreases twice as fast as normal items(ie. decreses by two every passig day)

        GildedRose app = new GildedRose(items);

        int days = 5;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i <= days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
        
        System.out.println("After " + (days+1) + " days of processing");
        System.out.println("name, sellIn, quality");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

}