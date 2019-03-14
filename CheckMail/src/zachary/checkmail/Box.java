package zachary.checkmail;

public class Box {
	
	private double dim1, dim2, dim3, weight;
	
	public Box(double d1, double d2, double d3, double w) {
		dim1 = d1;
		dim2 = d2;
		dim3 = d3;
		weight = w;
	}

	public String getStatus() {
		double length;
		double s1, s2;
		if(dim1>dim2) {
			if(dim1>dim3) {
				length = dim1;
				s1 = dim2;
				s2 = dim3;
			}
			else {
				if(dim2>dim3) {
					length = dim2;
					s1 = dim1;
					s2 = dim3;
				}
				else {
					length = dim3;
					s1 = dim1;
					s2 = dim2;
				}
			}
		}
		else {
			if(dim2>dim3) {
				length = dim2;
				s1 = dim1;
				s2 = dim3;
			}
			else {
				length = dim3;
				s1 = dim1;
				s2 = dim2;
			}
		}
		
		if(length + s1*2 + s2*2 < 100) {
			if(weight<70) return "Package is acceptable";
			return "Package is too heavy";
		}
		else {
			if(weight<70) return "Package is too large";
			return "Package is too large and too heavy";
		}
	}
	
}
