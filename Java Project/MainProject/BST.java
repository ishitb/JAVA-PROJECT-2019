/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package last;

/**
 *
 * @author Mihir
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import static javafx.scene.text.Font.font;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.LineBorder;
/**
 *
 * @author jkin
 */

//NODE CLASS

class Node
{
    int Key;
    Node left;
    Node right;
    public Node(){}
    public Node(int key)
    {
        this.Key=key;
    }
    public int getKey()
    { 
        return Key;
    }
    public Node getLeft() 
    { 
        return left; 
    }
    public Node setLeft(int Key) 
    {
	left = new Node(Key);
	return left;
    }
    public Node getRight() 
    { 
        return right; 
    }
    public Node setRight(int content) 
    {
	right = new Node(content);
	return right;
    }
}

//BST CLASS

public class BST 
{
    Node root=null,deleteparent,small;    
    public Node getRoot()
    {
        return root;
    }
    public Node addNode(int content) 
    {
        if (root == null) 
        {
            root = new Node(content);
            return root;        
        }
      return insert(root, content);
    }
    private Node insert(Node n, int c) 
    {
        if (c < n.getKey())
        {
            Node l = n.getLeft();
            if (l == null)
            return n.setLeft(c);
            else
            return insert(l, c);        
        } 
        
        else 
        {
            Node r = n.getRight();
            if (r == null)
            return n.setRight(c);
            else
            return insert(r, c);
        }
    }


    public Node searchNode(int d, Node n)
        {
          Node aux = null; //Not found
          if (d == n.getKey())
            return n; 
          else 
            if (d < n.getKey())         
               aux = searchNode(d, n.getLeft());
            else 
               aux = searchNode(d, n.getRight());   
         return aux;
       }
    

    int countNodes(Node n)
    {   int count;
        if(n==null)
        {
            return 0;
        }
        else
        {
            count=1;
            count=count+countNodes(n.getLeft());
            count=count+countNodes(n.getRight());
        }
        return count;
    }
         Node deleteKey(Node root, int key) 
    { 
        if (root == null)  return root; 

        if (key < root.Key) 
            root.left = deleteKey(root.left, key); 
        
        else if (key > root.Key) 
            root.right = deleteKey(root.right, key); 
  
        else
        { 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 

            root.Key = minValue(root.right); 
  
            // Delete the inorder successor 
            root.right = deleteKey(root.right, root.Key); 
        } 
  
        return root; 
    }
    int minValue(Node root) 
    { 
        int min = root.Key; 
        while (root.left != null) 
        { 
            min = root.left.Key; 
            root = root.left; 
        } 
        return min; 
    }
}

 class TheWindow extends JPanel implements ActionListener
{      int xLoc = 500, yLoc = 100,line_x=500,line_y=100;
        static JButton insert = new JButton("Insert"), delete = new JButton("Delete"), print = new JButton("Print"),find = new JButton("Search");
        static JTextField insertField = new JTextField(""), deleteField = new JTextField(""), vertices = new JTextField("0"), height = new JTextField("0"), printtf = new JTextField(""), findField = new JTextField("");
        static JTextField inordertf = new JTextField("Inorder: ");
        static JLabel ver = new JLabel("No. of Vertices : "), ht = new JLabel("Height of tree : ");
       static  String s1 = "";
       
//       COLORS
        static Color dark = new Color(52, 58, 64);
        static Color green = new Color(40, 167, 69);
        static Color red = new Color(200, 53, 69);
        static Color blue = new Color(0, 123, 255);
        static Color yellow = new Color(255, 193, 7);
        static Color light = new Color(230, 240, 250);
        
        static Font font = new Font("Helvetica", Font.BOLD, 20);
       
       private BST tree = null;
       private HashMap nodeLocations = null;
       private HashMap subtreeSizes = null;
       private boolean calculation = true;
       private int parent2child = 10, child2child = 20;
       private Dimension empty = new Dimension(0, 0);
       private FontMetrics fm = null;
       
       public TheWindow(BST tree)
       {   
             
        this.tree = tree;
        nodeLocations = new HashMap();
        subtreeSizes = new HashMap();
        insert.addActionListener(this);
        delete.addActionListener(this);
        find.addActionListener(this);
        print.addActionListener(this);
        
       }
       
       public static void main(String[] args) {
        // TODO code application logic here
        BST tree = new BST();
        JFrame f = new JFrame("Binary Tree");
        TheWindow f1 = new TheWindow(tree);
        f1.setBackground(new Color(52,58,64));
        f1.setBounds(400, 0, 1500, 860);
        f.add(f1);
        
        //DARK MODE TO BUTTONS
        insert.setBackground(green);
        insert.setForeground(light);
        insert.setFont(font);
        
        delete.setBackground(red);  
        delete.setForeground(light);
        delete.setFont(font);
        
        find.setBackground(blue);
        find.setForeground(light);
        find.setFont(font);
        
        print.setBackground(yellow);
        print.setForeground(light);
        print.setFont(font);
        
        
        //DARK MODE TO TEXT FIELDS
        insertField.setBackground(dark);
        insertField.setBorder(new LineBorder(light, 4));
        insertField.setForeground(light);
        insertField.setFont(font);
        
        deleteField.setBackground(dark);
        deleteField.setBorder(new LineBorder(light, 4));
        deleteField.setForeground(light);
        deleteField.setFont(font);
        
        findField.setBackground(dark);
        findField.setBorder(new LineBorder(light, 4));
        findField.setForeground(light);
        findField.setFont(font);
        
        ver.setOpaque(true);
        ver.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        ver.setBackground(dark);
        ver.setBorder(new LineBorder(light, 4));
        ver.setForeground(light);
        ver.setFont(font);
        
        vertices.setBackground(dark);
        vertices.setBorder(new LineBorder(light, 4));
        vertices.setForeground(light);
        vertices.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        vertices.setEditable(false);
        vertices.setFont(font);
        
        ht.setOpaque(true);
        ht.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        ht.setBackground(dark);
        ht.setBorder(new LineBorder(light, 4));
        ht.setForeground(light);
        ht.setFont(font);
        
        height.setBackground(dark);
        height.setBorder(new LineBorder(light, 4));
        height.setForeground(light);
        height.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        height.setEditable(false);
        height.setFont(font);
        
        inordertf.setBackground(dark);
        inordertf.setBorder(new LineBorder(light, 4));
        inordertf.setForeground(light);
        inordertf.setEditable(false);
        inordertf.setFont(font);
        
        
        
        
        
        
        JPanel p1 = new JPanel();
        p1.setBackground(Color.DARK_GRAY);
        JPanel p3 = new JPanel();
        p1.setLayout(new GridLayout(7, 1));
        p1.setBounds(0, 0,1000, 30);
        p1.add(insertField);
        p1.add(insert);
        p1.add(deleteField);
        p1.add(delete);
        p1.add(findField);
        p1.add(find);
        p1.add(print);
       // p1.setLayout(new GridLayout(8,1));
        //inordertf.setBounds(100,600,800,30);
        
        //=================================
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 1));
        p2.setBounds(100, 550, 800, 30);
        p2.add(ver);
        p2.add(vertices);
        p2.add(ht);
        p2.add(height);
        //=================================    
        p3.add(p1);
        p3.add(p2);
        p3.setLayout(new GridLayout(2,1));
        p3.setBounds(0, 0, 400, 860);
        f.add(p3);
        
        inordertf.setBounds(0, 860, 1900, 100);
        f.add(inordertf);
        
        f.setLayout(null);
        
        f.setSize(1905, 990);
        f.setVisible(true);  
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }  
       
@Override
        public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==insert)
        {  
            tree.addNode(Integer.parseInt(insertField.getText()));
            calculation=true;  
            vertices.setText(Integer.toString(tree.countNodes(tree.root)));
            height.setText(String.valueOf(ht(tree.root)));
            
            repaint();  
            insertField.setText("");
        }
        else if(ae.getSource()==delete)
        {
            tree.deleteKey(tree.getRoot(),Integer.parseInt(deleteField.getText()));
            calculation=true;
           vertices.setText(Integer.toString(tree.countNodes(tree.root)));
           height.setText(String.valueOf(ht(tree.root)));
//            printt(tree.getRoot());
            repaint();
//            s1 = " ";
            deleteField.setText("");
        }
       else if(ae.getSource()==find)
        {


            try{
                Node aux = tree.searchNode(Integer.parseInt(findField.getText()), tree.getRoot());
                inordertf.setText(aux.Key+" Found");
            }
            catch(Exception e){
                inordertf.setText(findField.getText()+" Not Found");
            }
            calculation= true;
            repaint();
        }
       else if(ae.getSource()==print)
           printt(tree.getRoot());
        s1 = " ";
    } 
    void printt(Node x)
    {
        if(x.left != null)
            printt(x.left);
        s1  = s1 +" " + String.valueOf(x.Key); 
        inordertf.setText("Inorder: "+s1);
        if(x.right != null)
            printt(x.right);
    }
    public void paint(Graphics g) 
    {
     super.paint(g);
     Font f = new Font("Arial",Font.BOLD,20);
     g.setFont(f);
     fm = g.getFontMetrics();
     // if node Locations not calculated
     if (calculation) {
       calculateLocations();
       calculation = false;
     }
     Graphics2D g2d = (Graphics2D) g;
     g2d.translate(getWidth() / 2, parent2child);
     drawTree(g2d, tree.getRoot(), Integer.MAX_VALUE, Integer.MAX_VALUE, fm.getLeading() + fm.getAscent());
     fm = null;
   }
    public void calculateLocations()
    {
        nodeLocations.clear();
        subtreeSizes.clear();
        Node root=tree.getRoot();
        if(root!=null)
        {
            calculateSubtreeSize(root);
            calculateLocation(root,Integer.MAX_VALUE,Integer.MAX_VALUE,0);    
        }
    }
    private Dimension calculateSubtreeSize(Node n)
    {
        if(n==null)
            return new Dimension(0,0);
        String s=Integer.toString(n.getKey());
        Dimension ld= calculateSubtreeSize(n.getLeft());
        Dimension rd= calculateSubtreeSize(n.getRight());
        int h=fm.getHeight()+parent2child+Math.max(ld.height, rd.height);
        int w=ld.width+child2child+rd.width;
        Dimension d=new Dimension (w,h);
        subtreeSizes.put(n, d);
        return d;
    }
      private void calculateLocation(Node n, int left, int right, int top)
      {
          if (n == null) 
             return;
          Dimension ld = (Dimension) subtreeSizes.get(n.getLeft());
          if (ld == null)
            ld = empty;
         Dimension rd = (Dimension) subtreeSizes.get(n.getRight());
         if (rd == null) 
              rd = empty;
         int center = 0;
        if (right != Integer.MAX_VALUE)
            center = right - rd.width - child2child/2;
        else if (left != Integer.MAX_VALUE)
          center = left + ld.width + child2child/2;
        int width = fm.stringWidth(Integer.toString(n.getKey()));
        Rectangle r = new Rectangle(center - width/2 - 3, top, width + 6, fm.getHeight());
        nodeLocations.put(n, r);
        calculateLocation(n.getLeft(), Integer.MAX_VALUE, center - child2child/2, top + fm.getHeight() + parent2child);
        calculateLocation(n.getRight(), center + child2child/2, Integer.MAX_VALUE, top + fm.getHeight() + parent2child);
      }
      private void drawTree(Graphics2D g, Node n, int px, int py, int yoffs) {
      if (n == null)   
      {
          
          return;
      }
      
      Rectangle r = (Rectangle) nodeLocations.get(n);

      g.draw(r);
      g.setColor(Color.MAGENTA);
      g.drawString(Integer.toString(n.getKey()), r.x + 3, r.y + yoffs);
      if (px != Integer.MAX_VALUE)
           
      //g.setColor(Color.GREEN);
      g.drawLine(px, py, r.x + r.width/2, r.y);
      g.setColor(Color.orange);
      drawTree(g, n.getLeft(), r.x + r.width/2, r.y + r.height, yoffs);
      drawTree(g, n.getRight(), r.x + r.width/2, r.y + r.height, yoffs);
   }
      
        
      int ht(Node root)
      { 
          if(root == null)
              return 0;
          else
          {
            int leftht, righttht ;
            leftht= ht(root.left);
            righttht = ht(root.right);
            if( leftht > righttht)
                 return leftht+1;
             else
                return righttht +1;
          }
              
      }
}