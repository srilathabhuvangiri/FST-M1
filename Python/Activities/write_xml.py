import pandas as pd

df = pd.DataFrame([[1.3, 1.4, 5.2],
                   [2.6, 1.4, 4.6],
                   [2.1, 5.6, 4.6]],
                  columns=['A', 'B', 'C'],
                  index=['X', 'Y', 'Z'])

xml_data = ['<root>']
for column in df.columns:
    xml_data.append('<{}>'.format(column))  # Opening element tag
    for field in df.index:
        # writing sub-elements
        xml_data.append('<{0}>{1}</{0}>'.format(field, df[column][field]))
    xml_data.append('</{}>'.format(column))  # Closing element tag
xml_data.append('</root>')

with open('coordinates.xml', 'w') as f:  # Writing in XML file
    for line in xml_data:
        f.write(line)