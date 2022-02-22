public class Main {

    public static void main(String[] args) {

        Vertex v1 = new Vertex(1,null, null);
        Vertex v2 = new Vertex(2,null, null);
        Vertex v8 = new Vertex(8,v1, v2);
        Vertex v6 = new Vertex(6,null, null);
        Vertex v4 = new Vertex(4,null, null);
        Vertex v3 = new Vertex(3,v4, v8);
        Vertex v5 = new Vertex(5,v6, v3);

        VertexService vertexService = new VertexService();
        System.out.println(vertexService.countHeight(v5));
    }
}
