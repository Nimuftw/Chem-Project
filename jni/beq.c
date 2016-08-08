//
// Created by vishn on 7/28/2016.
//
// element use table, then once parsed reused as molecule weights
u,t[99];

// molecules
char*s,*m[99]; // name and following separator
c,v[99][99]; // count-1, element vector

i,j,n;

// brute force solver, n==0 upon solution - assume at most 30 of each molecule
b(k){
    if(k<0)for(n=j=0;!n&&j<u;j++)for(i=0;i<=c;i++)n+=t[i]*v[i][j]; // check if sums to zero
    else for(t[k]=0;n&&t[k]++<30;)b(k-1); // loop through all combos of weights
}

main(int r,char**a){
    // parse
    for(s=m[0]=a[1];*s;){
        // parse separator, advance next molecule
        if(*s==45)r=0,s++;
        if(*s<65)m[++c]=++s;
        // parse element
        j=*s++;
        if(*s>96)j=*s+++j<<8;
        // lookup element index
        for(i=0,t[u]=j;t[i]-j;i++);
        u+=i==u;
        // parse amount
        for(n=0;*s>>4==3;)n=n*10+*s++-48;
        n+=!n;
        // store element count in molecule vector, flip sign for other side of '->'
        v[c][i]=r?n:-n;
    }
    // solve
    b(c);
    // output
    for(i=0,s=n?"Nope!":a[1];*s;putchar(*s++))s==m[i]&&t[i++]>1?printf("%d",t[i-1]):0;
    putchar(10);
}
