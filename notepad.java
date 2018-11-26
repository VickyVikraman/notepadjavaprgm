import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class MyNotepad extends Frame implements ActionListener {
	TextArea ta;
	Menu file;
	MenuItem New,Open,Save,Exit;
	MenuBar mb=new MenuBar();
	MyNotepad()
	{
		Frame f=new Frame();
		file=new Menu("File");
		New=new MenuItem("New");
		Open=new MenuItem("Open");
		Save=new MenuItem("Save");
		Exit=new MenuItem("Exit");
		ta=new TextArea();
		f.add(ta);
		file.add(New);
		file.add(Open);
		file.add(Save);
		file.add(Exit);
		mb.add(file);
		New.addActionListener(this);
		Open.addActionListener(this);
		Save.addActionListener(this);
		Exit.addActionListener(this);//Close notepad using Exit menu
		f.setTitle("MYNOTEPAD");
		f.setVisible(true);
		f.setSize(600,600);
		//f.setLayout(null);
		f.setMenuBar(mb);
		/*f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });*///for closing notepad window using close Tab
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==New)
		{
			ta.setText(" ");
		}
		else if(ae.getSource()==Open)
		{
			try
			{
				FileDialog fd=new FileDialog(this,"Open File",FileDialog.LOAD);
				fd.setVisible(true);
				String dir=fd.getDirectory();
				String fname=fd.getFile();
				FileInputStream fis=new FileInputStream(dir+fname);
				DataInputStream dis=new DataInputStream(fis);
				String str=" ",msg=" ";
				while((str=dis.readLine())!=null)
				{
					msg=msg+str;
					msg+="\n";
				}
				ta.setText(msg);
				dis.close();
			}
			catch(Exception e)
			{
			}
		}
		else if(ae.getSource()==Save)
		{
			try
			{
				FileDialog fd=new FileDialog(this,"Save File",FileDialog.SAVE);
				fd.setVisible(true);
				String txt=ta.getText();
				String dir=fd.getDirectory();
				String fname=fd.getFile();
				FileOutputStream fos=new FileOutputStream(dir+fname);
				DataOutputStream dos=new DataOutputStream(fos);
				dos.writeBytes(txt);
				dos.close();
			}
			catch(Exception e)
			{
			}
		}
		else if(ae.getSource()==Exit)
		{
			System.exit(0);
		}
	}
	public static void main(String a[])
	{
		MyNotepad mn=new MyNotepad();
	}
}
