package ħ���Z��;



public class Sy_zhan {
	    private char[] data = null;
	    private int maxSize=0;   //ջ����
	    private int top =-1;  //ջ��ָ��
	    private int head=0;//����ָ��
	    Sy_zhan(){
			this(10); //Ĭ��ջ��СΪ10
		}
	    Sy_zhan(int initialSize){
	    	if(initialSize>=0){
	    		this.maxSize=initialSize;
	    		data=new char[initialSize];
	    		top=-1;
	    	}
	    	else{
	    		throw new RuntimeException("��ʼ����С����С��0��"+initialSize);
	    	}
	    }
	  //�п�
	    public boolean empty(){
	    	return top==-1?true:false;
	    }
	  //��ջ,��һ��Ԫ��top=0��
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
	    //���������ֵ
	    public void equal(char[] e){
	    	if(top!=-1){
	    		throw new RuntimeException("ջ����ֵ");
	    	}
	    	else{
	            
	            for(int i=e.length-1;i>=0;i--){
	            	data[i]=e[i];
	            	top++;
	            	
	            }
	    	}
	    	
	    }
	  //�鿴ջ��Ԫ�ص����Ƴ�
	
		public char peek(){
	    	if(top==-1){
	    		throw new RuntimeException("ջΪ��");
	    	}
	    	else
	    		return data[top];
	    }
		 //����ջ��Ԫ��
	
		public char pop(){
	        if(top == -1){
	            throw new RuntimeException("ջΪ�գ�");
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

	    
	    //���ض����ڶ�ջ�е�λ�ã��� 1 Ϊ����
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
	    //����ָ��Ԫ��,1�����
	    public char zhiding(int a){
	        if(top == -1){
	            throw new RuntimeException("ջΪ�գ�");
	        }else{
	            return data[a-1];
	        }
	    }
	    

}
