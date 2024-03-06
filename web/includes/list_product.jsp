<%-- 
    Document   : list_product
    Created on : Dec 13, 2023, 8:48:11 AM
    Author     : Dell
--%>

<%@page contentType="text/html" import="Model.*,java.util.*" pageEncoding="UTF-8"%>
<%@page import="dal.*,java.util.*"%>
<%@page import="dal.FruitDB"%>
<%@page import="java.util.List"%>
    <!-- Product Listings Section -->
    <div class="container">
        <% 
            FruitDB fruitDB = new FruitDB();
            String[] list_product_img={"RedDeliciousApples","CavendishBananas", "NavelOranges", "Strawberries", "Lemons", "Pineapples"};
            List<Fruit> allFruits = fruitDB.getAll();
            int row = allFruits.size();
            int i = 0;
            for (Fruit o : allFruits)
                {
                    out.write("<div class='row'>");
                        out.write("<div class='col-md-4 mt-5' align='center'>");
                        %>
                        <img src="<%=path%>/images/<%=list_product_img[i]%>.jpg" class="card-img-top fixed-image">
        <%                
                            out.write("<div class='card'>");
                              out.write(" <div class='card-body'> <h5 class='card-title'> " + o.getProductName() + "</h5> <p class='card-text'>" + o.getDescription() +"</p> <p class='card-text'>Price: $" + o.getPrice() + "/kg</p> <div onclick ='getNumberOfProdutct("+i+")' class='btn btn-primary'>Add to Cart</div></div>") ; 
                            out.write("</div>");
                        out.write("</div>");
                    out.write("</div");
                    i++;
                }
        %>
            </form>
        </div>
    </div>