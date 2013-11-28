import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUnionFind {

	private static final int N = 10000;
	private UnionFind uf;

	@Before
	public void setUp() {
		uf = new UnionFind(N);
	}

	@Test
	public void testFindOnUnchangedSet() {
		for (int i = 0; i < N; i++) {
			Assert.assertEquals(uf.find(i), i);
		}
	}

	@Test
	public void testUnion() {
		Assert.assertNotEquals(uf.find(0), uf.find(1));
		uf.union(0, 1);
		Assert.assertEquals(uf.find(0), uf.find(1));

		Assert.assertEquals(uf.find(2), uf.find(2));
		uf.union(2, 2);
		Assert.assertEquals(uf.find(2), uf.find(2));
	}

	@Test
	public void testRandomUnion() {
		for (int i = 0; i < N; i++) {
			int point1 = new Random().nextInt(N);
			int point2 = new Random().nextInt(N);
			uf.union(point1, point2);
			Assert.assertEquals(uf.find(point1), uf.find(point2));
		}
	}

	@Test
	public void testConnected() {
		Assert.assertFalse(uf.connected(0, 1));
		uf.union(0, 1);
		Assert.assertTrue(uf.connected(0, 1));
	}

	@Test
	public void testRandomConnected() {
		for (int i = 0; i < N; i++) {
			int point1 = new Random().nextInt(N);
			int point2 = new Random().nextInt(N);
			uf.union(point1, point2);
			Assert.assertTrue(uf.connected(point1, point2));
		}
	}

}
