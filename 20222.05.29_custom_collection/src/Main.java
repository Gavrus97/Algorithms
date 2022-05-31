public class Main {

    public static void main(String[] args) {
	    ICustomCollection mc = new CustomCollection();
        System.out.println(mc.add(10L));
        System.out.println(mc.add(11L));
        System.out.println(mc.add(12L));
        System.out.println(mc.add(13L));
        System.out.println(mc.add(14L));
        System.out.println(mc.add(15L));
        System.out.println(mc.add(15L));
        System.out.println(mc.add(13L));
        System.out.println(mc.add(17L));
        System.out.println(mc.add(18L));
        System.out.println(mc.add(19L));
        System.out.println(mc.add(20L));
        System.out.println(mc.add(21L));
        System.out.println(mc.add(22L));
        System.out.println(mc.add(23L));
        System.out.println(mc.add(24L));
        System.out.println(mc.add(25L));
        System.out.println(mc.add(26L));
        System.out.println(mc.add(27L));
        System.out.println(mc.add(28L));
        System.out.println(mc.add(29L));
        System.out.println(mc);

        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc);
        System.out.println();

        System.out.println(mc.remove(10L));
        System.out.println(mc);
        System.out.println(mc.remove(20L));
        System.out.println(mc);
        System.out.println(mc.remove(30L));
        System.out.println(mc);
        System.out.println(mc.remove(14L));
        System.out.println(mc);
        System.out.println(mc.remove(13L));
        System.out.println(mc);
        System.out.println();

        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc.getRandom());
        System.out.println(mc);
        System.out.println();

    }
}
