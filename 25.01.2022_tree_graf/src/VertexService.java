public class VertexService {

    public int countHeight(Vertex root) {
        int count = 0;

        return count;
    }

    public int countVertices(Vertex root) {
        int count = 1;
        if (root.leftChild != null) {
            count += countVertices(root.leftChild);
        }
        if (root.rightChild != null) {
            count += countVertices(root.rightChild);
        }
        return count;
    }
}
