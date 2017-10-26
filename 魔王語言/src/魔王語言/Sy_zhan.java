package 魔王語言;



public class Sy_zhan {
	    private char[] data = null;
	    private int maxSize=0;   //栈容量
	    private int top =-1;  //栈顶指针
	    private int head=0;//队列指针
	    Sy_zhan(){
			this(10); //默认栈大小为10
		}
	    Sy_zhan(int initialSize){
	    	if(initialSize>=0){
	    		this.maxSize=initialSize;
	    		data=new char[initialSize];
	    		top=-1;
	    	}
	    	else{
	    		throw new RuntimeException("初始化大小不能小于0："+initialSize);
	    	}
	    }
	  //判空
	    public boolean empty(){
	    	return top==-1?true:false;
	    }
	  //进栈,第一个元素top=0；
	    public boolean push(char e){
	    	if(top==maxSize-1){
	    	char[] data1=new char[maxSize];
	    	System.arraycopy(data, 0, data1, 0, maxSize);
	    	data=new char[++maxSize];
	    	System.arraycopy(data1, 0, data, 0, maxSize-1);
	    	data[++top]=e;
	    	return true;
	    	
	    	}
	    	else{
    			top++;
    			data[top]=e;
    			return true;
    		}    	
	    }
	    //赋予数组的值
	    public void equal(char[] e){
	    	if(top!=-1){
	    		throw new RuntimeException("栈已有值");
	    	}
	    	else{
	            
	            for(int i=e.length-1;i>=0;i--){
	            	data[i]=e[i];
	            	top++;
	            	
	            }
	    	}
	    	
	    }
	  //查看栈顶元素但不移除
	
		public char peek(){
	    	if(top==-1){
	    		throw new RuntimeException("栈为空");
	    	}
	    	else
	    		return data[top];
	    }
		 //弹出栈顶元素
	
		public char pop(){
	        if(top == -1){
	            throw new RuntimeException("栈为空！");
	        }else{
	            return data[top--];
	        }
	    }
		public char read(){
			if(head>maxSize-1)
				return '0';
			else
				return data[head++];
			
			
		}

	    
	    //返回对象在堆栈中的位置，以 1 为基数
	    public int search(char e){
	        int i=top;
	        while(top != -1){
	            if(peek() != e){
	                top --;
	            }else{
	                break;
	            }
	        }
	        int result = top+1;
	        top = i;
	        return result;      
	    }
	    //返回指定元素,1為基数
	    public char zhiding(int a){
	        if(top == -1){
	            throw new RuntimeException("栈为空！");
	        }else{
	            return data[a-1];
	        }
	    }
	    

}
