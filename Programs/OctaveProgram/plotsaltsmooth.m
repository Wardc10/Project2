%Christopher Ward
%Octave Plot,Salt,Smooth Program

%EXAMPLE

%x = -10:0.1:10;
%plot (x, sin (x));
%xlabel ("x");
%ylabel ("sin (x)");
%title ("Simple 2-D Plot");

%PLOT

hold on;
%set x values and y (our function)
x = -10:0.5:10;
y = -x.^2;
%plot the function
plot(x, y, 'b', 'LineWidth', 2);
%set title
title("Unsalted Function");

%SALT

%use randn to generate salt
salted_y = y + randn(size(y));
%plot the salted function
plot(x, salted_y, 'r', 'LineWidth', 2);
%change the title
title("Salted Function");

%SMOOTH

%define our smoothing window
window = 5;
smoothed_y = movmean(salted_y, window);
%plot the smoothed function
plot(x, smoothed_y, 'g', 'LineWidth', 2);

% Add labels and change title
xlabel("x values");
ylabel("y values");
title("Smoothed Data");

title("y = x^2 : Original, Salted, Smoothed");
legend("Original", "Salted", "Smoothed");
%title("y = x^2 : Original, Salted, and Smoothed);

hold off;


